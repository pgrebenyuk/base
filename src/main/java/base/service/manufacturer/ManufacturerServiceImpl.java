package base.service.manufacturer;

import base.entity.Manufacturer;
import base.repository.manufacturer.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    @Qualifier("mySqlManufacturerRepository")
    private ManufacturerRepository manufacturerRepository;

    @Override
    public Manufacturer getRandomManufacturer() {
        List<Manufacturer> manufacturerAll = manufacturerRepository.getAll();
        int id = new Random().nextInt(manufacturerAll.size()) + 1;
        return manufacturerAll.get(id);
    }

}
