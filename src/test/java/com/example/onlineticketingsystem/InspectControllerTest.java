package com.example.onlineticketingsystem;

import com.example.onlineticketingsystem.DTO.InspectDTO;
import com.example.onlineticketingsystem.controller.InspectController;
import com.example.onlineticketingsystem.entity.Inspect;
import com.example.onlineticketingsystem.repo.InspectRepo;
import com.example.onlineticketingsystem.service.InspectService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/Inspect/getInspect")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)));
    }

}