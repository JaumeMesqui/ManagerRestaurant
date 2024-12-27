package mesqui.repositories;

import mesqui.model.Table;

import java.util.List;

public interface ManagerRepository {
    void insertTable(Table table);
    List<Table> getAllTables();
    Table getATable(Long id);
}
