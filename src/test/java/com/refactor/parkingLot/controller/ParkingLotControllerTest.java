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
import java.util.Arrays;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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

    @Test
    public void should_return_all_parkingLots_when_send_get_request() throws Exception {

         ParkingLot parkingLot1 = new ParkingLot("东南停车场",12);
        ParkingLot parkingLot2 = new ParkingLot("西南停车场",20);

        when(parkingLotService.findAll()).thenReturn(Arrays.asList(parkingLot1,parkingLot2));
        ResultActions resultActions = mockMvc.perform(get("/parkingLots"));

        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].name",equalTo("东南停车场")))
                .andExpect(jsonPath("$[1].name",equalTo("西南停车场")))
                .andExpect(jsonPath("$[0].size",equalTo(12)))
                .andExpect(jsonPath("$[1].size",equalTo(20)));

    }
}
