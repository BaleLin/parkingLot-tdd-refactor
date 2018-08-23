package com.refactor.parkingLot.entites;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int size;
    private int initSize;
    private String status = "open";
    public ParkingLot() {
    }

    public ParkingLot(Long id,String name, int initSize) {
        this(name,initSize);
        this.id = id;

    }

    public ParkingLot(String name, int initSize) {
        this.name = name;
        this.initSize = initSize;
        this.size=this.initSize;

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

    public int getInitSize() {
        return initSize;
    }

    public void setInitSize(int initSize) {
        this.initSize = initSize;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
