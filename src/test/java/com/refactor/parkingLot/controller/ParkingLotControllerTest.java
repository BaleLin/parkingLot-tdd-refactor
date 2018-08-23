package com.refactor.parkingLot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.refactor.parkingLot.entites.ParkingLot;
import com.refactor.parkingLot.service.ParkingLotService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ParkingLotController.class)
public class ParkingLotControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ParkingLotService parkingLotService;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void should_return_204_when_post_a_new_parkingLot() throws Exception {

        ParkingLot parkingLot = new ParkingLot("东南停车场",20);

        when(parkingLotService.createParkingLot(parkingLot)).thenReturn(parkingLot);
        ResultActions resultActions = mockMvc.perform(post("/parkingLots")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(parkingLot)));

        resultActions.andExpect(status().isCreated());
    }
}
