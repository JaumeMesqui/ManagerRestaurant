package mesqui.model;

import mesqui.constants.LocationEnum;

public class Table {

    private long id;
    private int minSeats;
    private int maxSeats;
    private LocationEnum location;

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

    @Override
    public String toString() {
        return "Table{" +
                "minSeats=" + minSeats +
                ", maxSeats=" + maxSeats +
                ", location=" + location +
                '}';
    }
}

