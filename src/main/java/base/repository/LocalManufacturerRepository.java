package base.repository;

import base.entity.Manufacturer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LocalManufacturerRepository implements ManufacturerRepository {
    private static Set<Manufacturer> manufacturers;

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
