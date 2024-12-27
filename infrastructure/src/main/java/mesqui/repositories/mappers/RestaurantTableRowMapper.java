package mesqui.repositories.mappers;

import mesqui.repositories.entities.RestaurantTable;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RestaurantTableRowMapper implements RowMapper<RestaurantTable> {

    @Override
    public RestaurantTable mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new RestaurantTable(
                rs.getLong("id"),
                rs.getInt("minSeats"),
                rs.getInt("maxSeats"),
                rs.getString("location")
        );
    }
}
