package base.service.manufacturer;

import base.configs.MyConfig;
import base.entity.Manufacturer;
import base.repository.article.ArticleRepository;
import base.repository.article.LocalArticleRepository;
import base.repository.manufacturer.LocalManufacturerRepository;
import base.repository.manufacturer.ManufacturerRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Set;

@Component
public class ManufacturerServiceImpl implements ManufacturerService {
    private final ManufacturerRepository manufacturerRepository = MyConfig
            .context
            .getBean(LocalManufacturerRepository.class);

    public ManufacturerServiceImpl() {
    }

    @Override
    public int getRandomManufacturersId() {
        Set<Manufacturer> manufacturerAll = manufacturerRepository.getAll();
        return new Random().nextInt(manufacturerAll.size()) + 1;
    }

}
