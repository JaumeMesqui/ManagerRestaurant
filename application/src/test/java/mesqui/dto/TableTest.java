package mesqui.dto;

import mesqui.constants.LocationEnum;
import mesqui.model.Table;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TableTest {

    private Table table;
    private mesqui.dto.Table tableDTO;

    @BeforeEach
    void setUp() {
        table = new Table(1, 2, LocationEnum.INDOOR);
        tableDTO = new mesqui.dto.Table(1, 2, 4, LocationEnum.OUTDOOR);
    }

    @Test
    void from() {
        var tableDTOResult = mesqui.dto.Table.from(table);
        assertEquals(1, tableDTOResult.getMinSeats());
        assertEquals(2, tableDTOResult.getMaxSeats());
        assertEquals(LocationEnum.INDOOR, tableDTOResult.getLocation());
    }

    @Test
    void of() {
        var tableResult = tableDTO.of();
        assertEquals(2, tableResult.getMinSeats());
        assertEquals(4, tableResult.getMaxSeats());
        assertEquals(LocationEnum.OUTDOOR, tableResult.getLocation());
    }
}
