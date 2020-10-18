package base.service.manufacturer;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public interface ManufacturerService {
    int getRandomManufacturersId();
}
