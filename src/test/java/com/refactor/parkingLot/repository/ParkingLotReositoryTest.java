package com.refactor.parkingLot.repository;

import com.refactor.parkingLot.entites.ParkingLot;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ParkingLotReositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @After
    public void clearEntityManager() {
        testEntityManager.clear();
    }

    @Test
    public void should_save_to_database_successfully_when_given_a_parkingLot() {

        ParkingLot parkingLot = new ParkingLot("东南停车场", 20);

        ParkingLot saveParkingLot = parkingLotRepository.save(parkingLot);

        assertThat(saveParkingLot).hasFieldOrPropertyWithValue("name", "东南停车场");
        assertThat(saveParkingLot).hasFieldOrPropertyWithValue("size", 20);

    }

    @Test
    public void should_query_all_parkingLots_when_call_findAll() {

        testEntityManager.persist(new ParkingLot("东南停车场", 20));
        testEntityManager.persist(new ParkingLot("西南停车场", 20));

        List<ParkingLot> parkingLotList = parkingLotRepository.findAll();

        Assert.assertEquals( 2,parkingLotList.size());
        Assert.assertEquals("东南停车场", parkingLotList.get(0).getName());
        Assert.assertEquals("西南停车场", parkingLotList.get(1).getName());
        Assert.assertEquals(20, parkingLotList.get(0).getSize());
        Assert.assertEquals(20, parkingLotList.get(1).getSize());

    }

    @Test
    public void should_update_the_parkingLot_successfully_when_cahnge_some_information_of_parkingLot() {

        testEntityManager.persist(new ParkingLot("东南停车场", 20));
        ParkingLot parkingLot = new ParkingLot(1L, "西南停车场", 20);

        parkingLotRepository.save(parkingLot);
        ParkingLot result = parkingLotRepository.findById(1L).get();

        Assert.assertEquals("西南停车场", result.getName());
        Assert.assertEquals(20, result.getSize());
    }
}
