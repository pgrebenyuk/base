package base.repository.manufacturer;

import base.entity.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;


@Service
public class MySqlManufacturerRepository implements ManufacturerRepository {

    //де модифікатор доступу?
    @Autowired
    EntityManager em;

    @Override
    public Set<Manufacturer> getAll() {
        return new HashSet<Manufacturer>(em
                .createQuery("from Manufacturer")
                .getResultList());
    }

}
