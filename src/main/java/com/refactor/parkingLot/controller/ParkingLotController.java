package com.refactor.parkingLot.controller;

import com.refactor.parkingLot.entites.ParkingLot;
import com.refactor.parkingLot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parkingLots")
public class ParkingLotController {
    @Autowired
    ParkingLotService parkingLotService;
    @PostMapping
    public ResponseEntity<ParkingLot> createParkingLot(@RequestBody ParkingLot parkingLot){
        ParkingLot saveParkingLot = parkingLotService.createParkingLot(parkingLot);
        return   new ResponseEntity<ParkingLot>(saveParkingLot,HttpStatus.CREATED);
    }
}
