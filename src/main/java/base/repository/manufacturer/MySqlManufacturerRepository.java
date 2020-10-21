package base.repository.manufacturer;

import base.entity.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;


@Service
public class MySqlManufacturerRepository implements ManufacturerRepository {
    private static final String SQL_SELECT_ALL = "SELECT c from Manufacturer c";

    @Autowired
    EntityManager entityManager;

    @Override
    public Set<Manufacturer> getAll() {
        return new HashSet<Manufacturer>(entityManager
                .createQuery(SQL_SELECT_ALL)
                .getResultList());
    }

}
