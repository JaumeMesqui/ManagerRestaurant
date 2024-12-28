package mesqui.services.manager;

import mesqui.constants.LocationEnum;
import mesqui.model.Table;

import java.util.List;

public interface ManagerService {

    void createTable(int minSeats, int maxSeats, LocationEnum location);
    List<Table> obtainAllTables();
    Table obtainATable(Long id);
    void modifyTable(int minSeats, int maxSeats, LocationEnum location);
    void removeTable(Long id);
}
