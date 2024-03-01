import org.example.controller.MainController;
import org.example.service.MainService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = MainController.class)
@AutoConfigureMockMvc
public class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MainService mainService; // Mockowanie serwisu

    @Test
    public void testGetEmployees() throws Exception {
        // Przygotowanie atrapy danych
        when(mainService.getEmployees()).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.get("/allEmployees"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetEmployers() throws Exception {
        // Przygotowanie atrapy danych
        when(mainService.getEmployers()).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.get("/allEmployers"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testAddStaff() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/addStaff/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
