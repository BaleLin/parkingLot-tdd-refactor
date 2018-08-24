package com.refactor.parkingLot.service;

import com.refactor.parkingLot.entites.ParkingLot;
import com.refactor.parkingLot.repository.ParkingLotRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ParkingLotServiceTest {
    @Test
    public void should_create_parkingLot_successfully_when_given_name_and_size() {

        ParkingLotRepository mockRepository = mock(ParkingLotRepository.class);
        ParkingLotService parkingLotService = new ParkingLotService(mockRepository);
        ParkingLot parkingLot = new ParkingLot("东南停车场", 12);

        when(mockRepository.save(parkingLot)).thenReturn(parkingLot);
        ParkingLot result = parkingLotService.createParkingLot(parkingLot);

        Assert.assertEquals("东南停车场", result.getName());
        Assert.assertEquals(12, result.getSize());
    }

    @Test
    public void should_get_empty_result_set_when_no_parkingLot() {

        ParkingLotRepository mockRepository = mock(ParkingLotRepository.class);
        ParkingLotService parkingLotService = new ParkingLotService(mockRepository);

        when(mockRepository.findAll()).thenReturn(new ArrayList<>());
        List<ParkingLot> results = parkingLotService.findAll();

        Assert.assertEquals( 0,results.size());
    }

    @Test
    public void should_query_all_parkingLots_when_find_all_parkingLots() {

        ParkingLotRepository mockRepository = mock(ParkingLotRepository.class);
        ParkingLotService parkingLotService = new ParkingLotService(mockRepository);
        ParkingLot parkingLot1 = new ParkingLot("东南停车场", 12);
        ParkingLot parkingLot2 = new ParkingLot("西南停车场", 20);

        when(mockRepository.findAll()).thenReturn(Arrays.asList(parkingLot1, parkingLot2));
        List<ParkingLot> results = parkingLotService.findAll();

        Assert.assertEquals(2,results.size());
        Assert.assertEquals("东南停车场", results.get(0).getName());
        Assert.assertEquals(12, results.get(0).getSize());
        Assert.assertEquals("西南停车场", results.get(1).getName());
        Assert.assertEquals(20, results.get(1).getSize());
    }

    @Test
    public void should_update_the_parkingLot_successfully_when_cahnge_some_information_of_parkingLot() {

        ParkingLotRepository mockRepository = mock(ParkingLotRepository.class);
        ParkingLotService parkingLotService = new ParkingLotService(mockRepository);
        ParkingLot parkingLot = new ParkingLot(1L, "东南停车场", 12);

        when(mockRepository.findById(1L)).thenReturn(Optional.of(parkingLot));
        when(mockRepository.save(parkingLot)).thenReturn(parkingLot);

        try {
            parkingLotService.updateParkingLot(parkingLot);
            verify(mockRepository).save(parkingLot);
        } catch (Exception exception) {
            fail("should update sucessfully,but fail");
        }
    }


    @Test
    public void should_update_the_parkingLot_fail_when_cahnge_some_information_of_parkingLot() {

        ParkingLotRepository mockRepository = mock(ParkingLotRepository.class);
        ParkingLotService parkingLotService = new ParkingLotService(mockRepository);
        ParkingLot parkingLot = new ParkingLot(1L, "东南停车场", 12);

        when(mockRepository.save(parkingLot)).thenReturn(parkingLot);

        try {
            parkingLotService.updateParkingLot(parkingLot);
            verify(mockRepository).save(parkingLot);
            fail("should update fail,but sucessfully");
        } catch (Exception exception) {
            assertEquals("update error", exception.getMessage());
        }
    }
}
