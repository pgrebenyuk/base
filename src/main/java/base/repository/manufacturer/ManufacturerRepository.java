package base.repository.manufacturer;

import base.entity.Manufacturer;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface ManufacturerRepository {
    //зміни всюди, щоб був List, а не Set
    //нам тут особливості сета не пригодяться
    Set<Manufacturer> getAll();
}
