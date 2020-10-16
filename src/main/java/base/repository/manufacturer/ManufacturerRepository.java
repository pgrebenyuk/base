package base.repository.manufacturer;

import base.entity.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ManufacturerRepository {
    Set<Manufacturer> getAll();
}
