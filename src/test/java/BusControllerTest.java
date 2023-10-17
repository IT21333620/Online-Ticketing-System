import com.example.onlineticketingsystem.controller.BusController;
import com.example.onlineticketingsystem.entity.Bus;
import com.example.onlineticketingsystem.repo.BusRepo;
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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class BusControllerTest {
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private BusRepo busRepo;

    @InjectMocks
    private BusController busController;

    Bus RECORD_1 = new Bus(0, 5, 4, 54);
    Bus RECORD_2 = new Bus(0, 6, 5, 50);

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(busController).build();
    }

    @Test
    public void getAllBusRecords_success() throws Exception{
        List<Bus> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2));

        Mockito.when(busRepo.findAll()).thenReturn(records);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/bus/getBus")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2))


        );
    }
}
