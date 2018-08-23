package com.refactor.parkingLot.entites;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ParkingLot {
    @Id
    private Long id;
    private String name;
    private int size;

    public ParkingLot(String name, int size) {
        this.id = id;
        this.name = name;
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
