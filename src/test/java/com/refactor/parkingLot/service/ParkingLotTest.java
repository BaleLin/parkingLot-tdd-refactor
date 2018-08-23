package com.refactor.parkingLot.service;

import com.refactor.parkingLot.entites.ParkingLot;
import com.refactor.parkingLot.repository.ParkingLotRepository;
import com.refactor.parkingLot.servies.ParkingLotService;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParkingLotTest {
   @Test
   public void should_create_parkingLot_successfully_when_given_name_and_size(){

       ParkingLotRepository mockRepository = mock(ParkingLotRepository.class);
       ParkingLotService parkingLotService = new ParkingLotService(mockRepository);
       ParkingLot parkingLot=new ParkingLot("东南停车场",12);

       when(mockRepository.save(parkingLot)).thenReturn(parkingLot);
       ParkingLot result = parkingLotService.createParkingLot(parkingLot);

       Assert.assertEquals("东南停车场",result.getName());
       Assert.assertEquals(12,result.getSize());
   }
}
