package base.repository.manufacturer;

import base.entity.Manufacturer;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface ManufacturerRepository {
    Set<Manufacturer> getAll();
}
