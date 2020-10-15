package base.repository.manufacturer;

import base.entity.Manufacturer;
import org.springframework.stereotype.Component;

import java.util.Set;

//в спрінг є спеціальні анотації для репозиторія @Repository
//по суті це то й же компонент, але просто позначає репозиторій
@Component
public interface ManufacturerRepository {
    Set<Manufacturer> getAll();
}
