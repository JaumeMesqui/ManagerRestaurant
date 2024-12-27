package mesqui;

import mesqui.constants.LocationEnum;
import mesqui.dto.Table;
import mesqui.services.ManagerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @PostMapping("/table")
    public void createTable(@RequestBody Table table){
        managerService.createTable(table.getMinSeats(), table.getMaxSeats(), LocationEnum.INDOOR);
    }

    @GetMapping("/tables")
    public List<Table> obtainAllTables() {
        var tables = managerService.obtainAllTables();
        return tables.stream().map(Table::from).toList();
    }

    @GetMapping("/table/{id}")
    public Table obtainTable(@PathVariable Long id) {
        var table = managerService.obtainATable(id);
        return Table.from(table);
    }

    @PostMapping("/table/{id}")
    public void modifyTable(String id) {
    }

    @DeleteMapping("/{id}")
    public void removeTable() {
    }
}
