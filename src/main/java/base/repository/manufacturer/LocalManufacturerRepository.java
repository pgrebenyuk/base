package base.repository.manufacturer;

import base.entity.Manufacturer;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public abstract class LocalManufacturerRepository implements ManufacturerRepository {
    private List<Manufacturer> manufacturers;

    private LocalManufacturerRepository() {
        manufacturers = Arrays.asList(
                new Manufacturer( "first"),
                new Manufacturer( "second"),
                new Manufacturer( "thirt")
        );
    }

    public List<Manufacturer> getAll() {
        return manufacturers;
    }

    public Optional<Manufacturer> findById(int id){
        return manufacturers.stream()
                .filter(article -> article.getId() == id)
                .findFirst();
    }

}
