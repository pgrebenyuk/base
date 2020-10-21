package base.repository.manufacturer;

import base.entity.Manufacturer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ManufacturerMapper implements RowMapper<Manufacturer> {
    private static final String COLUMN_ID_MANUFACTURER = "id_manufacturer";
    private static final String COLUMN_MANUFACTURER = "manufacturer";

    public Manufacturer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(rs.getInt(COLUMN_ID_MANUFACTURER));
        manufacturer.setName(rs.getString(COLUMN_MANUFACTURER));
        return manufacturer;
    }
}
