package base.service;

import base.entity.Manufacturer;
import base.repository.ManufacturerRepositoryImpl;

import java.util.HashSet;
import java.util.Set;

public class ManufacturerServiceImpl implements ManufacturerService {

    @Override
    public int size() {
        try {
            ManufacturerRepositoryImpl dao = new ManufacturerRepositoryImpl();
            Set<Manufacturer> manufacturerAll = new HashSet<>(dao.getAll());
            return manufacturerAll.size();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }

}