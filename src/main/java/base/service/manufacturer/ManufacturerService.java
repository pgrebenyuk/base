package base.service.manufacturer;

import base.entity.Manufacturer;
import org.springframework.stereotype.Service;

@Service
public interface ManufacturerService {
    Manufacturer getRandomManufacturer();
}
