package base.service.manufacturer;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
public interface ManufacturerService {
    int getRandomManufacturersId();
}
