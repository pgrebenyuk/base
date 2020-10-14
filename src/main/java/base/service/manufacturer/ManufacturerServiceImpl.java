package base.service.manufacturer;

import base.entity.Manufacturer;
import base.repository.manufacturer.ManufacturerRepository;

import java.util.Random;
import java.util.Set;

public class ManufacturerServiceImpl implements ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public int getRandomManufacturersId() {
        Set<Manufacturer> manufacturerAll = manufacturerRepository.getAll();
        return new Random().nextInt(manufacturerAll.size()) + 1;
    }

}
