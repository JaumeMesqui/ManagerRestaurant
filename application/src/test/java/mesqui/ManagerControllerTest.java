package mesqui;

import mesqui.constants.LocationEnum;
import mesqui.dto.Table;
import mesqui.services.manager.ManagerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ManagerControllerTest {

    private ManagerController managerController;

    @Mock
    private ManagerService managerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        managerController = new ManagerController(managerService);
    }

    @Test
    void createTable() {
        managerController.createTable(new Table(1, 1, 2, LocationEnum.INDOOR));
        verify(managerService, times(1))
                .createTable(1, 2, LocationEnum.INDOOR);
    }

    @Test
    void obtainAllTables() {
        mesqui.model.Table table = new mesqui.model.Table(1, 2, LocationEnum.INDOOR);
        when(managerService.obtainAllTables()).thenReturn(List.of(table));
        var tables = managerController.obtainAllTables();
        verify(managerService, times(1)).obtainAllTables();
        assertEquals(1, tables.getFirst().getMinSeats());
        assertEquals(2, tables.getFirst().getMaxSeats());
        assertEquals(LocationEnum.INDOOR, tables.getFirst().getLocation());
    }

    @Test
    void obtainTable() {
        when(managerService.obtainATable(anyLong()))
                .thenReturn(new mesqui.model.Table(1, 2, LocationEnum.INDOOR));
        var table = managerController.obtainTable(1L);
        verify(managerService, times(1)).obtainATable(anyLong());
        assertEquals(1, table.getMinSeats());
        assertEquals(2, table.getMaxSeats());
        assertEquals(LocationEnum.INDOOR, table.getLocation());
    }

    @Test
    void modifyTable() {
        managerController.modifyTable(new Table(1, 1, 2, LocationEnum.INDOOR));
        verify(managerService, times(1))
                .modifyTable(1L, 1, 2, LocationEnum.INDOOR);
    }

    @Test
    void removeTable() {
        managerController.removeTable(1L);
        verify(managerService, times(1)).removeTable(1L);
    }
}
