package base.repository.manufacturer;

import base.entity.Manufacturer;
import java.util.Set;

public interface ManufacturerRepository {
    Set<Manufacturer> getAll();
}
