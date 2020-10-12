package base.service;

import base.entity.Manufacturer;
import base.repository.ManufacturerRepositoryImpl;

import java.util.Set;

public class ManufacturerServiceImpl implements ManufacturerService {

    @Override
    public int getManufacturersCount() {
        ManufacturerRepositoryImpl dao = new ManufacturerRepositoryImpl();
        Set<Manufacturer> manufacturerAll = dao.getAll();
        return manufacturerAll.size();
    }

}
