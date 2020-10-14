package base.repository.manufacturer;

import base.entity.Manufacturer;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public interface ManufacturerRepository {
    Set<Manufacturer> getAll();
}
