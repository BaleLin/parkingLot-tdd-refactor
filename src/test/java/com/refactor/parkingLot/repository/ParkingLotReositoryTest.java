package com.refactor.parkingLot.repository;

import com.refactor.parkingLot.entites.ParkingLot;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ParkingLotReositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ParkingLotRepository parkingLotRepository;
    
    @Test
    public void should_save_to_database_successfully_when_given_a_parkingLot(){

        ParkingLot parkingLot = new ParkingLot("东南停车场",20);
         ParkingLot saveParkingLot = parkingLotRepository.save(parkingLot);
         assertThat(saveParkingLot).hasFieldOrPropertyWithValue("name","东南停车场");
        assertThat(saveParkingLot).hasFieldOrPropertyWithValue("size",20);

    }

    @Test
    public void should_query_all_parkingLots_when_call_findAll(){
        testEntityManager.persist(new ParkingLot("东南停车场",20));
        testEntityManager.persist(new ParkingLot("西南停车场",20));
        List<ParkingLot> parkingLotList = parkingLotRepository.findAll();
        Assert.assertEquals(parkingLotList.size(),2);
        Assert.assertEquals(parkingLotList.get(0).getName(),"东南停车场");
        Assert.assertEquals(parkingLotList.get(1).getName(),"西南停车场");
        Assert.assertEquals(parkingLotList.get(0).getSize(),20);
        Assert.assertEquals(parkingLotList.get(1).getSize(),20);

    }
}
