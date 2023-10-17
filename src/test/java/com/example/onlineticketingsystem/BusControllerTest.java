package com.example.onlineticketingsystem;

import com.example.onlineticketingsystem.controller.BusController;
import com.example.onlineticketingsystem.DTO.BusDTO;
import com.example.onlineticketingsystem.service.BusService;
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

public class BusControllerTest {

    @InjectMocks
    private BusController busController;

    @Mock
    private BusService busService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(busController).build();
    }

    @Test
    public void testGetBus() throws Exception {
        List<BusDTO> busDTOList = new ArrayList<>();
        busDTOList.add(new BusDTO(1, 2, 3, 50));
        busDTOList.add(new BusDTO(2, 3, 4, 60));

        when(busService.getAllBuses()).thenReturn(busDTOList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/bus/getBus"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json("[{\"id\":1,\"busOwnerID\":2,\"routeNo\":3,\"capacity\":50},{\"id\":2,\"busOwnerID\":3,\"routeNo\":4,\"capacity\":60}]"))
                .andDo(print());

        verify(busService, times(1)).getAllBuses();
        verifyNoMoreInteractions(busService);
    }

    @Test
    public void testSaveBus() throws Exception {
        BusDTO busDTO = new BusDTO(1, 2, 3, 50);

        //Positive test case.
        when(busService.saveBus(any(BusDTO.class))).thenReturn(busDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/bus/saveBus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"busOwnerID\":2,\"routeNo\":3,\"capacity\":50}")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json("{\"id\":1,\"busOwnerID\":2,\"routeNo\":3,\"capacity\":50}"))
                .andDo(print());

        verify(busService, times(1)).saveBus(any(BusDTO.class));
        verifyNoMoreInteractions(busService);

        //Negative test case.
        when(busService.saveBus(any(BusDTO.class))).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/bus/saveBus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"busOwnerID\":2,\"routeNo\":3,\"capacity\":50}")
                )
                .andExpect(MockMvcResultMatchers.status().isInternalServerError()) //Assuming you return 500 for a failure
                .andDo(print());

        verify(busService, times(1)).saveBus(any(BusDTO.class));
        verifyNoMoreInteractions(busService);
    }
    @Test
    public void testUpdateBus() throws Exception {
        BusDTO busDTO = new BusDTO(1, 2, 3, 50);

        when(busService.updateBus(any(BusDTO.class))).thenReturn(busDTO);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/bus/updateBus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"busOwnerID\":2,\"routeNo\":3,\"capacity\":50}")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json("{\"id\":1,\"busOwnerID\":2,\"routeNo\":3,\"capacity\":50}"))
                .andDo(print());

        verify(busService, times(1)).updateBus(any(BusDTO.class));
        verifyNoMoreInteractions(busService);
    }

    @Test
    public void testDeleteBus() throws Exception {
        BusDTO busDTO = new BusDTO(1, 2, 3, 50);

        when(busService.deleteBus(any(BusDTO.class))).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/bus/deleteBus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"busOwnerID\":2,\"routeNo\":3,\"capacity\":50}")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("true"))
                .andDo(print());

        verify(busService, times(1)).deleteBus(any(BusDTO.class));
        verifyNoMoreInteractions(busService);
    }

}
