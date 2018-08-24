package com.refactor.parkingLot.repository;

import com.refactor.parkingLot.entites.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot,Long>,JpaSpecificationExecutor<ParkingLot> {

}
