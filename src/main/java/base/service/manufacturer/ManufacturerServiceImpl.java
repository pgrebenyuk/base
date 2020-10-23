package base.service.manufacturer;

import base.entity.Manufacturer;
import base.repository.manufacturer.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    @Qualifier("mySqlManufacturerRepository")
    private ManufacturerRepository manufacturerRepository;

    @Override
    public Optional<Manufacturer>  getRandomManufacturer() {
        int id = new Random().nextInt( (int) manufacturerRepository.count()) + 1;
        return manufacturerRepository.findById(id);
    }

}
