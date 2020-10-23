package base.repository.manufacturer;

import base.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {

}
