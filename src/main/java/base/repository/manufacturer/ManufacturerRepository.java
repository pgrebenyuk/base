package base.repository.manufacturer;

import base.entity.Manufacturer;
import org.springframework.context.annotation.ComponentScan;

import java.util.Set;

@ComponentScan
public interface ManufacturerRepository {
    Set<Manufacturer> getAll();
}
