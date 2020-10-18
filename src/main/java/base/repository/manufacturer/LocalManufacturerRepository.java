package base.repository.manufacturer;

import base.entity.Manufacturer;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@ComponentScan
public class LocalManufacturerRepository implements ManufacturerRepository {
    private Set<Manufacturer> manufacturers;

    public LocalManufacturerRepository() {
        manufacturers = new HashSet<>(Arrays.asList(
                new Manufacturer(1, "first"),
                new Manufacturer(2, "second"),
                new Manufacturer(3, "thirt")
        ));
    }

    @Override
    public Set<Manufacturer> getAll() {
        return manufacturers;
    }

}
