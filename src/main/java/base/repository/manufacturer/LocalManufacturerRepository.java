package base.repository.manufacturer;

import base.entity.Manufacturer;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class LocalManufacturerRepository implements ManufacturerRepository {
    private List<Manufacturer> manufacturers;

    public LocalManufacturerRepository() {
        manufacturers = Arrays.asList(
                new Manufacturer( "first"),
                new Manufacturer( "second"),
                new Manufacturer( "thirt")
        );
    }

    @Override
    public List<Manufacturer> getAll() {
        return manufacturers;
    }

    @Override
    public Optional<Manufacturer> manufacturerId(int id){
        return manufacturers.stream()
                .filter(article -> article.getId() == id)
                .findFirst();
    }

}
