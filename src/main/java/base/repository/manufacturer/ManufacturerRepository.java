package base.repository.manufacturer;

import base.entity.Manufacturer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ManufacturerRepository {
    List<Manufacturer> getAll();
    Optional<Manufacturer> manufacturerId(int id);
}
