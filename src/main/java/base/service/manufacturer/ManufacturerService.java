package base.service.manufacturer;

import base.entity.Manufacturer;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ManufacturerService {
    Optional<Manufacturer> getRandomManufacturer();
}
