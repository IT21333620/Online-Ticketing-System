package com.example.onlineticketingsystem;

import com.example.onlineticketingsystem.DTO.RouteDTO;
import com.example.onlineticketingsystem.controller.RouteController;
import com.example.onlineticketingsystem.service.RouteService;
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

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class RouteControllerTest {

    @InjectMocks
    private RouteController routeController;

    @Mock
    private RouteService routeService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(routeController).build();
    }

    @Test
    public void testGetRoute() throws Exception {
        List<RouteDTO> routeDTOList = new ArrayList<>();
        routeDTOList.add(new RouteDTO(1, 101, "Start1", "End1", "Active"));
        routeDTOList.add(new RouteDTO(2, 102, "Start2", "End2", "Inactive"));

        when(routeService.getAllRoutes()).thenReturn(routeDTOList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/route/getRoute"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());

        verify(routeService, times(1)).getAllRoutes();
        verifyNoMoreInteractions(routeService);
    }

    @Test
    public void testSaveRoute() throws Exception {
        RouteDTO routeDTO = new RouteDTO(1, 101, "Start1", "End1", "Active");

        when(routeService.saveRoute(any(RouteDTO.class))).thenReturn(routeDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/route/saveRoute")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"routeNo\":101,\"start\":\"Start1\",\"end\":\"End1\",\"status\":\"Active\"}")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());

        verify(routeService, times(1)).saveRoute(any(RouteDTO.class));
        verifyNoMoreInteractions(routeService);
    }

    @Test
    public void testUpdateRoute() throws Exception {
        RouteDTO routeDTO = new RouteDTO(1, 101, "Start1", "End1", "Active");

        when(routeService.updateRoute(any(RouteDTO.class))).thenReturn(routeDTO);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/route/updateRoute")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"routeNo\":101,\"start\":\"Start1\",\"end\":\"End1\",\"status\":\"Active\"}")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());

        verify(routeService, times(1)).updateRoute(any(RouteDTO.class));
        verifyNoMoreInteractions(routeService);
    }

    @Test
    public void testDeleteRoute() throws Exception {
        when(routeService.deleteRoute(any(RouteDTO.class))).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/route/deleteRoute")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"routeNo\":101,\"start\":\"Start1\",\"end\":\"End1\",\"status\":\"Active\"}")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());

        verify(routeService, times(1)).deleteRoute(any(RouteDTO.class));
        verifyNoMoreInteractions(routeService);
    }
}
