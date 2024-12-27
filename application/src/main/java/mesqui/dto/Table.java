package mesqui.dto;

import mesqui.constants.LocationEnum;

public class Table {

    private long id;
    private int minSeats;
    private int maxSeats;
    private LocationEnum location;

    public Table() {
    }

    public Table(long id, int minSeats, int maxSeats, LocationEnum location) {
        this.id = id;
        this.minSeats = minSeats;
        this.maxSeats = maxSeats;
        this.location = location;
    }

    public Table(int minSeats, int maxSeats, LocationEnum location) {
        this.minSeats = minSeats;
        this.maxSeats = maxSeats;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMinSeats() {
        return minSeats;
    }

    public void setMinSeats(int minSeats) {
        this.minSeats = minSeats;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
    }

    public LocationEnum getLocation() {
        return location;
    }

    public void setLocation(LocationEnum location) {
        this.location = location;
    }

    public static Table from(mesqui.model.Table table) {
        return new Table(table.getId(), table.getMinSeats(), table.getMaxSeats(), table.getLocation());
    }

    public mesqui.model.Table of() {
        return new mesqui.model.Table(this.getMinSeats(), this.getMaxSeats(), this.getLocation());
    }
}
