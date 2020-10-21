package base.repository.manufacturer;

import base.entity.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MySqlManufacturerRepository implements ManufacturerRepository {
    private static final String COLUMN_ID_MANUFACTURER = "id_manufacturer";
    private static final String COLUMN_MANUFACTURER = "manufacturer";
    private static final String SQL_SELECT_ALL = "SELECT * FROM manufacturers";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Set<Manufacturer> getAll() {
        return new HashSet<>(jdbcTemplate.query(SQL_SELECT_ALL, new ManufacturerMapper()));
    }

}
