package base.service;

import base.entity.Manufacturer;
import base.repository.ManufacturerRepository;
import base.repository.ManufacturerRepositoryImpl;

import java.util.Set;

public class ManufacturerServiceImpl implements ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl() {
        this.manufacturerRepository = new ManufacturerRepositoryImpl();
    }

    @Override
    public int getManufacturersCount() {
        Set<Manufacturer> manufacturerAll = manufacturerRepository.getAll();
        return manufacturerAll.size();
    }

}
