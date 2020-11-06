package base.controller.rest;

import base.entity.Article;
import base.entity.Manufacturer;
import base.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleRestController {

    @Autowired
    private KafkaTemplate<Long, Article> kafkaTemplate;

    @Autowired
    private ArticleService articleService;

    @GetMapping(value = "/rest/article", produces = MediaType.APPLICATION_JSON_VALUE)
//    @Cacheable(value = "articles", key = "#id")
    public Article doRest(@RequestParam int id) {
        Article article = articleService.getArticle(id)
                .orElse(new Article("error", 0, new Manufacturer( "error")));
        ListenableFuture<SendResult<Long, Article>> future = kafkaTemplate.send("msg", article);
        future.addCallback(System.out::println, System.err::println);
        kafkaTemplate.flush();
        return article;
    }

    @Cacheable("articles")
    @GetMapping(value = "/rest/articles", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Article> doRest() {
        return articleService.getAll();
    }

}
