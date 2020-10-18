package base.repository.manufacturer;

import base.entity.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

@Service
public class MySqlManufacturerRepository implements ManufacturerRepository {
    private static final String COLUMN_ID_MANUFACTURER = "id_manufacturer";
    private static final String COLUMN_MANUFACTURER = "manufacturer";
    private static final String SQL_SELECT_ALL = "SELECT * FROM manufacturers";

    @Autowired
    private Connection connection;

    private Manufacturer extractUserFromResultSet(ResultSet rs) throws SQLException {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(rs.getInt(COLUMN_ID_MANUFACTURER));
        manufacturer.setName(rs.getString(COLUMN_MANUFACTURER));

        return manufacturer;
    }

    @Override
    public Set<Manufacturer> getAll() {
        Set<Manufacturer> manufacturersAll = new HashSet<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);

            while (resultSet.next()) {
                Manufacturer manufacturer = extractUserFromResultSet(resultSet);
                manufacturersAll.add(manufacturer);
            }
            return manufacturersAll;

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return manufacturersAll;
    }

}
