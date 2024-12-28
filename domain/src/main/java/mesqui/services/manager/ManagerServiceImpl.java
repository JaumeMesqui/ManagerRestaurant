package mesqui.services.manager;

import mesqui.constants.LocationEnum;
import mesqui.model.Table;
import mesqui.repositories.ManagerRepository;

import java.util.List;

public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public void createTable(int minSeats, int maxSeats, LocationEnum location) {
        Table table = new Table(minSeats, maxSeats, location);
        managerRepository.insertTable(table);
    }

    @Override
    public List<Table> obtainAllTables() {
        return managerRepository.getAllTables();
    }

    @Override
    public Table obtainATable(Long id) {
        return managerRepository.getATable(id);
    }

    @Override
    public void modifyTable(int minSeats, int maxSeats, LocationEnum location) {
        Table table = new Table(minSeats, maxSeats, location);
        managerRepository.updateTable(table);
    }

    @Override
    public void removeTable(Long id) {
        managerRepository.deleteTable(id);
    }
}
