package base.repository.manufacturer;

import base.entity.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


@Service
public class MySqlManufacturerRepository implements ManufacturerRepository {

    @Autowired
    private EntityManager em;

    @Override
    public List<Manufacturer> getAll() {
        return em.createQuery("from Manufacturer")
                .getResultList();
    }

    @Override
    public Optional<Manufacturer> manufacturerId(int id) {
        return Optional.of(em.find(Manufacturer.class, id));
    }

}
