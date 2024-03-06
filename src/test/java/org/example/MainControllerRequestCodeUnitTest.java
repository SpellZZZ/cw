package org.example;
import org.example.controller.MainController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MainController.class)
public class MainControllerRequestCodeUnitTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MainController mainController;

    @Test
    void getEmployeesTest() throws Exception {

        when(mainController.getEmployees()).thenReturn(null);
        this.mockMvc.perform(get("/allEmployees"))
                .andExpect(status().isOk());
    }

    @Test
    void getEmployersTest() throws Exception {

        when(mainController.getEmployers()).thenReturn(null);
        this.mockMvc.perform(get("/allEmployers"))
                .andExpect(status().isOk());
    }


    @Test
    void addStaffTestValid() throws Exception {
        int validType = 1;

        this.mockMvc.perform(post("/addStaff/{type}", validType))
                .andExpect(status().isOk());
    }

}
