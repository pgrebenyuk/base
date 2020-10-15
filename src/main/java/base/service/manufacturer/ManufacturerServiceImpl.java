package base.service.manufacturer;

import base.entity.Manufacturer;
import base.repository.manufacturer.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Set;

//в спрінг є спеціальні анотації для сервіса @Service
//по суті це то й же компонент, але просто позначає сервіс
@Component
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
