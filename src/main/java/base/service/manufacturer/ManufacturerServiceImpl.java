package base.service.manufacturer;

import base.entity.Manufacturer;
import base.repository.manufacturer.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;

import java.util.Random;
import java.util.Set;

@ComponentScan
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    @Qualifier("localManufacturerRepository")
    private ManufacturerRepository manufacturerRepository;

    @Override
    public int getRandomManufacturersId() {
        Set<Manufacturer> manufacturerAll = manufacturerRepository.getAll();
        return new Random().nextInt(manufacturerAll.size()) + 1;
    }

}
