package base.repository.article;

import base.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
