package com.refactor.parkingLot.repository;

import com.refactor.parkingLot.entites.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot,Long> {

}
