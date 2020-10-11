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
            //цю стрічку правильно писати так
            //метод ж повертає сет, то просто присвой його
            //Set<Manufacturer> manufacturerAll = dao.getAll();
            Set<Manufacturer> manufacturerAll = new HashSet<>(dao.getAll());
            return manufacturerAll.size();
        //ніхто не кидає цю помилку
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
