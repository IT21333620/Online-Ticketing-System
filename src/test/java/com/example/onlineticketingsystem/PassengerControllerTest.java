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
    public void testGetPassengerById_Passing() throws Exception {
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
    public void testGetPassengerById_Failing() throws Exception {
        // Arrange
        int userID = 1; // Set the expected userID to 1
        PassengerDTO passengerDTO = new PassengerDTO(1, "shadhir", "shadhir03@gmail.com", "0768824668", "sha123", "passenger", 550);

        // Mock the service call, but return a different userID (e.g., userID = 2)
        given(passengerService.getPassengerById(anyInt())).willReturn(new PassengerDTO(2, "differentUser", "different@email.com", "1234567890", "differentPass", "otherType", 1000));

        // Act and Assert (Expecting failure)
        mockMvc.perform(get("/api/tickets/passengerById/{userID}", userID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userID").value(1)) // This should fail
                .andExpect(jsonPath("$.name").value("shadhir"))
                .andExpect(jsonPath("$.email").value("shadhir03@gmail.com"))
                .andExpect(jsonPath("$.contactNo").value("0768824668"))
                .andExpect(jsonPath("$.password").value("sha123"))
                .andExpect(jsonPath("$.userType").value("passenger"))
                .andExpect(jsonPath("$.balance").value(550));
    }

    @Test
    public void testGetPassengerById_FailingHttpStatus() throws Exception {
        // Arrange
        int userID = 1;
        PassengerDTO passengerDTO = new PassengerDTO(1, "shadhir", "shadhir03@gmail.com", "0768824668", "sha123", "passenger", 550);

        // Mock the service call
        given(passengerService.getPassengerById(anyInt())).willReturn(passengerDTO);

        // Act and Assert (Expecting failure)
        mockMvc.perform(get("/api/tickets/passengerById/{userID}", userID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound()); // Expecting a different status code (e.g., 404) which will fail
    }

    @Test
    public void testCreatePassenger_Passing() throws Exception {
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
    public void testCreatePassenger_Failing() throws Exception {
        // Arrange
        PassengerDTO passengerDTO = new PassengerDTO(1, "shadhir", "shadhir03@gmail.com", "0768824668", "sha123", "passenger", 550);

        // Mock the service call
        Mockito.when(passengerService.savePassenger(any(PassengerDTO.class))).thenReturn(passengerDTO);

        // Act and Assert (Expecting failure)
        mockMvc.perform(post("/api/tickets/createPassenger")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectWriter.writeValueAsString(passengerDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userID").value(2)); // Expecting a different userID (e.g., 2), which will fail
    }

    @Test
    public void testCreatePassenger_FailingHttpStatus() throws Exception {
        // Arrange
        PassengerDTO passengerDTO = new PassengerDTO(1, "shadhir", "shadhir03@gmail.com", "0768824668", "sha123", "passenger", 550);

        // Mock the service call
        Mockito.when(passengerService.savePassenger(any(PassengerDTO.class))).thenReturn(passengerDTO);

        // Act and Assert (Expecting failure)
        mockMvc.perform(post("/api/tickets/createPassenger")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectWriter.writeValueAsString(passengerDTO)))
                .andExpect(status().isCreated()); // Expecting a different status code (e.g., 201 Created) which will fail
    }


    @Test
    public void testUpdateBalanceByUserId_Passing() throws Exception {
        // Arrange
        int userID = 1;
        int amount = 100; // Amount to add to the balance

        // Mock the service behavior
        Mockito.doNothing().when(passengerService).updateBalanceByUserId(amount, userID); // Mock service call to update the balance
        Mockito.when(passengerService.getBalanceByUserId(userID)).thenReturn(550 + amount); // Mock service call to get updated balance

        // Act and Assert (Expecting success)
        mockMvc.perform(put("/api/tickets/updateBalance/{amount}/{userID}", amount, userID))
                .andExpect(status().isOk()) // Expecting HTTP status code 200
                .andExpect(content().string("650")); // Expecting the updated balance in the response body
    }

    @Test
    public void testUpdateBalanceByUserId_FailingHttpStatus() throws Exception {
        // Arrange
        int userID = 1;
        int amount = 100; // Amount to add to the balance

        // Mock the service behavior
        Mockito.doNothing().when(passengerService).updateBalanceByUserId(amount, userID); // Mock service call to update the balance
        Mockito.when(passengerService.getBalanceByUserId(userID)).thenReturn(550 + amount); // Mock service call to get updated balance

        // Act and Assert (Expecting failure)
        mockMvc.perform(put("/api/tickets/updateBalance/{amount}/{userID}", amount, userID))
                .andExpect(status().isNotFound()); // Expecting a different status code (e.g., 404 Not Found) which will fail
    }

    @Test
    public void testUpdateBalanceByUserIdFailingBalance() throws Exception {
        // Arrange
        int userID = 1;
        int amount = 100; // Amount to add to the balance

        // Mock the service behavior
        Mockito.doNothing().when(passengerService).updateBalanceByUserId(amount, userID); // Mock service call to update the balance
        Mockito.when(passengerService.getBalanceByUserId(userID)).thenReturn(550); // Mock service call to return a different balance value

        // Act and Assert (Expecting failure)
        mockMvc.perform(put("/api/tickets/updateBalance/{amount}/{userID}", amount, userID))
                .andExpect(status().isOk())
                .andExpect(content().string("650")); // Expecting a different balance value (e.g., "650") which will fail
    }





}
