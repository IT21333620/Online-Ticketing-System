package com.example.onlineticketingsystem;

import com.example.onlineticketingsystem.DTO.InspectDTO;
import com.example.onlineticketingsystem.controller.InspectController;
import com.example.onlineticketingsystem.entity.Inspect;
import com.example.onlineticketingsystem.service.InspectService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class InspectControllerTest {

    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private InspectService inspectService;

    @InjectMocks
    private InspectController inspectController;

    InspectDTO Inspect_1 = new InspectDTO(1, 2, 4, 177, Date.valueOf("2023-10-16"), Time.valueOf("12:30:00"), 3, 130);
    InspectDTO Inspect_2 = new InspectDTO(2, 2, 6, 180, Date.valueOf("2023-10-17"), Time.valueOf("12:30:00"), 3, 130);
    InspectDTO Inspect_3 = new InspectDTO(3, 5, 13, 177, Date.valueOf("2023-10-18"), Time.valueOf("12:30:00"), 3, 130);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(inspectController).build();
    }

    @Test
    public void getAllInspects_success() throws Exception {
        List<InspectDTO> listInspect = new ArrayList<>();
        listInspect.add(Inspect_1);
        listInspect.add(Inspect_2);
        listInspect.add(Inspect_3);


        when(inspectService.getAllInspects()).thenReturn(listInspect);

        mockMvc.perform(get("/api/Inspect/getInspect")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)));
    }

    @Test
    public void getAllInspects_404_fail() throws Exception {
        List<InspectDTO> listInspect = new ArrayList<>();
        listInspect.add(Inspect_1);
        listInspect.add(Inspect_2);
        listInspect.add(Inspect_3);


//        when(inspectService.getAllInspects()).thenReturn(listInspect);

        mockMvc.perform(get("/api/inspect/getInspect")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getByInspectorId_pass() throws Exception {
        // Arrange
        int inspectorId = 5;
        List<Inspect> inspectList = new ArrayList<Inspect>();
        inspectList.add(new Inspect(12, 5, 3, 177, Date.valueOf("2023-10-14"), Time.valueOf("12:30:00"), 6, 170));

        // Mock the service call
        given(inspectService.getInspectsByInspectorId(anyInt())).willReturn(inspectList);

        // Act and Assert
        mockMvc.perform(get("/api/Inspect/byInspector/{id}", inspectorId)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].inspectId").value(12))
                .andExpect(jsonPath("$[0].inspectorId").value(5))
                .andExpect(jsonPath("$[0].busId").value(3))
                .andExpect(jsonPath("$[0].routeId").value(177))
                .andExpect(jsonPath("$[0].inspectDate").value("1697221800000"))
                .andExpect(jsonPath("$[0].inspectTime").value("12:30:00"))
                .andExpect(jsonPath("$[0].noFraudDetected").value(6))
                .andExpect(jsonPath("$[0].noOfPassengers").value(170));
    }

    @Test
    public void getByInspectorId_fail() throws Exception {
        // Arrange
        int inspectorId = 5;
        List<Inspect> inspectList = new ArrayList<Inspect>();
        inspectList.add(new Inspect(12, 5, 3, 177, Date.valueOf("2023-10-14"), Time.valueOf("25:00:01"), 6, 170));

        // Mock the service call
        given(inspectService.getInspectsByInspectorId(anyInt())).willReturn(inspectList);

        // Act and Assert
        mockMvc.perform(get("/api/Inspect/byInspector/{id}", inspectorId)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].inspectId").value(12))
                .andExpect(jsonPath("$[0].inspectorId").value(5))
                .andExpect(jsonPath("$[0].busId").value(3))
                .andExpect(jsonPath("$[0].routeId").value(177))
                .andExpect(jsonPath("$[0].inspectDate").value("1697221800000"))
                .andExpect(jsonPath("$[0].inspectTime").value("12:30:00"))
                .andExpect(jsonPath("$[0].noFraudDetected").value(6))
                .andExpect(jsonPath("$[0].noOfPassengers").value(170));
    }



    @Test
    public void getByInspectorId_fail2() throws Exception {
        // Arrange
        int inspectorId = 10;
        List<Inspect> inspectList = new ArrayList<Inspect>();
        inspectList.add(new Inspect(1, 10, 3, 177, Date.valueOf("2023-10-14"), Time.valueOf("12:30:00"), 6, 170));

        // Mock the service call
        given(inspectService.getInspectsByInspectorId(anyInt())).willReturn(inspectList);

        // Act and Assert
        mockMvc.perform(get("/api/Inspect/byInspector/{id}", inspectorId)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].inspectId").value(12))
                .andExpect(jsonPath("$[0].inspectorId").value(10))
                .andExpect(jsonPath("$[0].busId").value(3))
                .andExpect(jsonPath("$[0].routeId").value(177))
                .andExpect(jsonPath("$[0].inspectDate").value("1697221800000"))
                .andExpect(jsonPath("$[0].inspectTime").value("12:30:00"))
                .andExpect(jsonPath("$[0].noFraudDetected").value(6))
                .andExpect(jsonPath("$[0].noOfPassengers").value(170));
    }

    @Test
    public void get_history() throws Exception {
        // Arrange
        int inspectorId = 10;
        List<Inspect> inspectList = new ArrayList<Inspect>();
        inspectList.add(new Inspect(1, 10, 3, 177, Date.valueOf("2023-10-11"), Time.valueOf("12:30:00"), 6, 170));

        // Mock the service call
        given(inspectService.getInspectHistoryByInspectorId(anyInt())).willReturn(inspectList);

        // Act and Assert
        mockMvc.perform(get("/api/Inspect/getInspectorHistory/{id}", inspectorId)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].inspectId").value(1))
                .andExpect(jsonPath("$[0].inspectorId").value(10))
                .andExpect(jsonPath("$[0].busId").value(3))
                .andExpect(jsonPath("$[0].routeId").value(177))
                .andExpect(jsonPath("$[0].inspectDate").value("1696962600000"))
                .andExpect(jsonPath("$[0].inspectTime").value("12:30:00"))
                .andExpect(jsonPath("$[0].noFraudDetected").value(6))
                .andExpect(jsonPath("$[0].noOfPassengers").value(170));
    }
    @Test
    public void get_history_fail() throws Exception {
        // Arrange
        int inspectorId = 10;
        List<Inspect> inspectList = new ArrayList<Inspect>();
        inspectList.add(new Inspect(1, 10, 3, 212, Date.valueOf("2023-11-11"), Time.valueOf("12:30:00"), 6, 170));

        // Mock the service call
        given(inspectService.getUpcomingInspectByInspectorId(anyInt())).willReturn(inspectList);

        // Act and Assert
        mockMvc.perform(get("/api/Inspect/getInspectorUpComing/{id}", inspectorId)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].inspectId").value(1))
                .andExpect(jsonPath("$[0].inspectorId").value(10))
                .andExpect(jsonPath("$[0].busId").value(3))
                .andExpect(jsonPath("$[0].routeId").value(1))
                .andExpect(jsonPath("$[0].inspectDate").value("1668105000000"))
                .andExpect(jsonPath("$[0].inspectTime").value("12:30:00"))
                .andExpect(jsonPath("$[0].noFraudDetected").value(6))
                .andExpect(jsonPath("$[0].noOfPassengers").value(170));
    }

    @Test
    public void get_history_fail2() throws Exception {
        // Arrange
        int inspectorId = 10;
        List<Inspect> inspectList = new ArrayList<Inspect>();
        inspectList.add(new Inspect(1, 10, 3, 212, Date.valueOf("2023-11-11"), Time.valueOf("12:30:00"), 6, 170));

        // Mock the service call
        given(inspectService.getUpcomingInspectByInspectorId(anyInt())).willReturn(inspectList);

        // Act and Assert
        mockMvc.perform(get("/api/Inspect/getInspectorUpComing/", inspectorId)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].inspectId").value(1))
                .andExpect(jsonPath("$[0].inspectorId").value(10))
                .andExpect(jsonPath("$[0].busId").value(3))
                .andExpect(jsonPath("$[0].routeId").value(1))
                .andExpect(jsonPath("$[0].inspectDate").value("1668105000000"))
                .andExpect(jsonPath("$[0].inspectTime").value("12:30:00"))
                .andExpect(jsonPath("$[0].noFraudDetected").value(6))
                .andExpect(jsonPath("$[0].noOfPassengers").value(170));
    }


}