package mesqui.repositories;

import mesqui.model.Table;
import mesqui.repositories.entities.RestaurantTable;
import mesqui.repositories.mappers.RestaurantTableRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManagerRepositoryImpl implements ManagerRepository{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ManagerRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertTable(Table table) {
        String sql = String.format("INSERT into restaurant_tables (minSeats, maxSeats, location) VALUES " +
                "(%d, %d, '%s')", table.getMinSeats(), table.getMaxSeats(), table.getLocation().name());
        jdbcTemplate.update(sql);
    }

    @Override
    public List<Table> getAllTables() {
        String sql = "SELECT id, minSeats, maxSeats, location FROM restaurant_tables";
        var restaurantTable = jdbcTemplate.query(sql, new RestaurantTableRowMapper());
        return restaurantTable.stream().map(RestaurantTable::from).toList();
    }

    @Override
    public Table getATable(Long id) {
        String sql = "SELECT id, minSeats, maxSeats, location FROM restaurant_tables" +
                "WHERE id = " + id;
        var restaurantTable = jdbcTemplate.query(sql, new RestaurantTableRowMapper());
        return RestaurantTable.from(restaurantTable.getFirst());
    }

    @Override
    public void updateTable(Table table) {
        String sql = String.format("UPDATE restaurant_tables SET minSeats = %d, maxSeats = %d, location = '%s'" +
                        "WHERE id = %d",
                table.getMinSeats(), table.getMaxSeats(), table.getLocation().name(), table.getId());
        jdbcTemplate.update(sql);
    }

    @Override
    public void deleteTable(Long id) {
        String sql = String.format("DELETE restaurant_tables WHERE id = %d", id);
        jdbcTemplate.update(sql);
    }
}
