package base.repository.manufacturer;

import base.entity.Manufacturer;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class LocalManufacturerRepository implements ManufacturerRepository {
    private Set<Manufacturer> manufacturers;

    public LocalManufacturerRepository() {
        manufacturers = new HashSet<>(Arrays.asList(
                new Manufacturer( "first"),
                new Manufacturer( "second"),
                new Manufacturer( "thirt")
        ));
    }

    @Override
    public Set<Manufacturer> getAll() {
        return manufacturers;
    }

}
