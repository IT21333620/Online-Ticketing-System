package com.example.onlineticketingsystem;

import com.example.onlineticketingsystem.DTO.PassengerDTO;
import com.example.onlineticketingsystem.controller.PassengerController;
import com.example.onlineticketingsystem.entity.Passenger;
import com.example.onlineticketingsystem.repo.PassengerRepo;
import com.example.onlineticketingsystem.service.PassengerService;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class PassengerControllerTest {

    @Mock
    private PassengerRepo passengerRepo;

    @Mock
    private PassengerService passengerService;

    @InjectMocks
    private PassengerController passengerController;

    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    Passenger RECORD_1 = new Passenger(1,"shadhir","shadhir03@gmail.com","0768824668","sha123","passenger",550);
    Passenger RECORD_2 = new Passenger(2,"shadhir1","shadhir04@gmail.com","0768824667","sha124","passenger",450);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(passengerController).build();
    }

    @Test
    public void testGetPassengerById0() throws Exception {
        // Arrange
        int userID = 1;
        PassengerDTO passengerDTO = new PassengerDTO(1, "shadhir", "shadhir03@gmail.com", "0768824668", "sha123", "passenger", 550);

        // Mock the service call
        given(passengerService.getPassengerById(anyInt())).willReturn(passengerDTO);

        // Act and Assert
        mockMvc.perform(get("/api/tickets/passengerById/{userID}", userID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userID").value(1))
                .andExpect(jsonPath("$.name").value("shadhir"))
                .andExpect(jsonPath("$.email").value("shadhir03@gmail.com"))
                .andExpect(jsonPath("$.contactNo").value("0768824668"))
                .andExpect(jsonPath("$.password").value("sha123"))
                .andExpect(jsonPath("$.userType").value("passenger"))
                .andExpect(jsonPath("$.balance").value(550));

        // Verify that the service method was called with the correct parameter
        Mockito.verify(passengerService).getPassengerById(userID);
    }

    @Test
    public void testGetPassengerById1() throws Exception {
        // Arrange
        int useriD = 1;
        PassengerDTO passengerDTO = new PassengerDTO(1, "shadhir", "shadhir03@gmail.com", "0768824668", "sha123", "passenger", 550);

        // Mock the service call
        given(passengerService.getPassengerById(anyInt())).willReturn(passengerDTO);

        // Act and Assert
        mockMvc.perform(get("/api/tickets/passengerById/{userID}", useriD)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.useriD").value(1))
                .andExpect(jsonPath("$.name").value("shadhir"))
                .andExpect(jsonPath("$.email").value("shadhir03@gmail.com"))
                .andExpect(jsonPath("$.contactNo").value("0768824668"))
                .andExpect(jsonPath("$.password").value("sha123"))
                .andExpect(jsonPath("$.userType").value("passenger"))
                .andExpect(jsonPath("$.balance").value(550));

        // Verify that the service method was called with the correct parameter
        Mockito.verify(passengerService).getPassengerById(useriD);
    }

    @Test
    public void testGetPassengerById2() throws Exception {
        // Arrange
        int userID = 1;
        PassengerDTO passengerDTO = new PassengerDTO(1, "shadhir", "shadhir03@gmail.com", "0768824668", "sha123", "passenger", 550);

        // Mock the service call
        given(passengerService.getPassengerById(anyInt())).willReturn(passengerDTO);

        // Act and Assert
        mockMvc.perform(get("/api/tickets/passengerById/{userID}", userID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userID").value(1))
                .andExpect(jsonPath("$.name").value("shadhir"))
                .andExpect(jsonPath("$.email").value("shadhir03@gmail.com"))
                .andExpect(jsonPath("$.phone").value("0768824668"))
                .andExpect(jsonPath("$.password").value("sha123"))
                .andExpect(jsonPath("$.account").value("passenger"))
                .andExpect(jsonPath("$.balance").value(550));

        // Verify that the service method was called with the correct parameter
        Mockito.verify(passengerService).getPassengerById(userID);
    }

    @Test
    public void testCreatePassenger0() throws Exception {
        // Arrange
        PassengerDTO passengerDTO = new PassengerDTO(1, "shadhir", "shadhir03@gmail.com", "0768824668", "sha123", "passenger", 550);

        // Mock the service call
        Mockito.when(passengerService.savePassenger(any(PassengerDTO.class))).thenReturn(passengerDTO);

        // Act and Assert
        mockMvc.perform(post("/api/tickets/createPassenger")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectWriter.writeValueAsString(passengerDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userID").value(1))
                .andExpect(jsonPath("$.name").value("shadhir"))
                .andExpect(jsonPath("$.email").value("shadhir03@gmail.com"))
                .andExpect(jsonPath("$.contactNo").value("0768824668"))
                .andExpect(jsonPath("$.password").value("sha123"))
                .andExpect(jsonPath("$.userType").value("passenger"))
                .andExpect(jsonPath("$.balance").value(550));
    }

    @Test
    public void testCreatePassenger1() throws Exception {
        // Arrange
        PassengerDTO passengerDTO = new PassengerDTO(1, "shadhir", "shadhir03@gmail.com", "0768824668", "sha123", "passenger", 550);

        // Mock the service call
        Mockito.when(passengerService.savePassenger(any(PassengerDTO.class))).thenReturn(passengerDTO);

        // Act and Assert
        mockMvc.perform(post("/api/tickets/createPassenger")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectWriter.writeValueAsString(passengerDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user").value(1))
                .andExpect(jsonPath("$.name").value("shadhir"))
                .andExpect(jsonPath("$.email").value("shadhir03@gmail.com"))
                .andExpect(jsonPath("$.contactNo").value("0768824668"))
                .andExpect(jsonPath("$.password").value("sha123"))
                .andExpect(jsonPath("$.role").value("passenger"))
                .andExpect(jsonPath("$.balance").value(550));
    }

    @Test
    public void testCreatePassenger2() throws Exception {
        // Arrange
        PassengerDTO passengerDTO = new PassengerDTO(1, "shadhir", "shadhir03@gmail.com", "0768824668", "sha123", "passenger", 550);

        // Mock the service call
        Mockito.when(passengerService.savePassenger(any(PassengerDTO.class))).thenReturn(passengerDTO);

        // Act and Assert
        mockMvc.perform(post("/api/tickets/createPassenger")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectWriter.writeValueAsString(passengerDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userID").value(2))
                .andExpect(jsonPath("$.name").value("shadhir"))
                .andExpect(jsonPath("$.email").value("shadhir03@gmail.com"))
                .andExpect(jsonPath("$.contactNo").value("0768824668"))
                .andExpect(jsonPath("$.password").value("sha@123"))
                .andExpect(jsonPath("$.userType").value("passenger"))
                .andExpect(jsonPath("$.balance").value(550));
    }

    @Test
    public void testUpdateBalanceByUserId0() throws Exception {
        // Arrange
        int userID = 1;
        int updatedBalance = 600; // This should be the updated balance after the operation

        // Mock the service methods
        Mockito.doNothing().when(passengerService).updateBalanceByUserId(anyInt(), anyInt());
        Mockito.when(passengerService.getBalanceByUserId(anyInt())).thenReturn(updatedBalance);

        // Act and Assert
        mockMvc.perform(put("/api/tickets/updateBalance/{amount}/{userID}", 50, userID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(updatedBalance));
    }





}
