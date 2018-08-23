package com.refactor.parkingLot.service;

import com.refactor.parkingLot.entites.ParkingLot;
import com.refactor.parkingLot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotService {

    @Autowired
    private ParkingLotRepository repository;

    public ParkingLotService(ParkingLotRepository repository) {
        this.repository=repository;
    }

    public ParkingLot createParkingLot(ParkingLot parkingLot) {
        return repository.save(parkingLot);

    }

    public List<ParkingLot> findAll() {
        return repository.findAll();
    }
}
