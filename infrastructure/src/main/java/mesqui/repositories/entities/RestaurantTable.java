package mesqui.repositories.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import mesqui.constants.LocationEnum;

@Entity
@Table(name = "restaurant_tables")
public class RestaurantTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "minSeats", nullable = false)
    private int minSeats;

    @Column(name = "maxSeats", nullable = false)
    private int maxSeats;

    @Column(name = "location", length = 255)
    private String location;

    @Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public RestaurantTable(Long id, int minSeats, int maxSeats, String location) {
        this.id = id;
        this.minSeats = minSeats;
        this.maxSeats = maxSeats;
        this.location = location;
    }

    public static mesqui.model.Table from(RestaurantTable restaurantTable) {
        return new mesqui.model.Table(
                restaurantTable.getId(),
                restaurantTable.getMinSeats(),
                restaurantTable.getMaxSeats(),
                LocationEnum.valueOf(restaurantTable.location)
        );
    }
}

