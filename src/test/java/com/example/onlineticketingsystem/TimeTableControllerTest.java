package com.example.onlineticketingsystem;

import com.example.onlineticketingsystem.controller.TimeTableController;
import com.example.onlineticketingsystem.DTO.TimeTableDTO;
import com.example.onlineticketingsystem.service.TimeTableService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class TimeTableControllerTest {

    @InjectMocks
    private TimeTableController timeTableController;

    @Mock
    private TimeTableService timeTableService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(timeTableController).build();
    }

    @Test
    public void testGetTimetable() throws Exception {
        List<TimeTableDTO> timeTableDTOList = new ArrayList<>();
        timeTableDTOList.add(new TimeTableDTO(1, 2, 3, "Monday", Time.valueOf("08:00:00")));
        timeTableDTOList.add(new TimeTableDTO(2, 3, 4, "Tuesday", Time.valueOf("09:00:00")));

        when(timeTableService.getAllTimetable()).thenReturn(timeTableDTOList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/timetable/getTimetable"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json("[{\"scheduleNo\":1,\"routeID\":2,\"busID\":3,\"day\":\"Monday\",\"startTime\":\"08:00:00\"},{\"scheduleNo\":2,\"routeID\":3,\"busID\":4,\"day\":\"Tuesday\",\"startTime\":\"09:00:00\"}]"));

        verify(timeTableService, times(1)).getAllTimetable();
        verifyNoMoreInteractions(timeTableService);
    }


    @Test
    public void testSaveTimetable() throws Exception {
        TimeTableDTO timeTableDTO = new TimeTableDTO(1, 2, 3, "Monday", Time.valueOf("08:00:00"));

        when(timeTableService.saveTimetable(any(TimeTableDTO.class))).thenReturn(timeTableDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/timetable/saveTimetable")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"scheduleNo\":1,\"routeID\":2,\"busID\":3,\"day\":\"Monday\",\"startTime\":\"08:00:00\"}")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json("{\"scheduleNo\":1,\"routeID\":2,\"busID\":3,\"day\":\"Monday\",\"startTime\":\"08:00:00\"}"));

        verify(timeTableService, times(1)).saveTimetable(any(TimeTableDTO.class));
        verifyNoMoreInteractions(timeTableService);

        //Negative test case.
        when(timeTableService.saveTimetable(any(TimeTableDTO.class))).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/timetable/saveTimetable")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"scheduleNo\":1,\"routeID\":2,\"busID\":3,\"day\":\"Monday\",\"startTime\":\"08:00:00\"}")
                )
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());

        verify(timeTableService, times(1)).saveTimetable(any(TimeTableDTO.class));
        verifyNoMoreInteractions(timeTableService);
    }


    @Test
    public void testUpdateTimetable() throws Exception {
        TimeTableDTO timeTableDTO = new TimeTableDTO(1, 2, 3, "Monday", Time.valueOf("08:00:00"));

        when(timeTableService.updateTimetable(any(TimeTableDTO.class))).thenReturn(timeTableDTO);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/timetable/updateTimetable")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"scheduleNo\":1,\"routeID\":2,\"busID\":3,\"day\":\"Monday\",\"startTime\":\"08:00:00\"}")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json("{\"scheduleNo\":1,\"routeID\":2,\"busID\":3,\"day\":\"Monday\",\"startTime\":\"08:00:00\"}"));

        verify(timeTableService, times(1)).updateTimetable(any(TimeTableDTO.class));
        verifyNoMoreInteractions(timeTableService);
    }


    @Test
    public void testDeleteTimetable() throws Exception {
        TimeTableDTO timeTableDTO = new TimeTableDTO(1, 2, 3, "Monday", Time.valueOf("08:00:00"));

        when(timeTableService.deleteTimetable(any(TimeTableDTO.class))).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/timetable/deleteTimetable")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"scheduleNo\":1,\"routeID\":2,\"busID\":3,\"day\":\"Monday\",\"StartTime\":\"08:00:00\"}")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("true"));

        verify(timeTableService, times(1)).deleteTimetable(any(TimeTableDTO.class));
        verifyNoMoreInteractions(timeTableService);
    }
}
