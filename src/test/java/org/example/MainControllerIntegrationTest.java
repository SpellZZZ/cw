package org.example;

import org.example.Main;
import org.example.controller.MainController;
import org.example.model.Employee;
import org.example.model.Employer;
import org.example.service.MainService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private MainService mainService;

    @Test
    void getEmployees() throws Exception {

        Mockito.when(mainService.getEmployees()).thenReturn(List.of(new Employee("pracownik", "pracownik")));

        mockMvc.perform(MockMvcRequestBuilders.get("/allEmployees")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("pracownik"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].surName").value("pracownik"));
    }

    @Test
    void getEmployers() throws Exception {
        Mockito.when(mainService.getEmployers()).thenReturn(List.of(new Employer("pracownik", "pracownik")));

        mockMvc.perform(MockMvcRequestBuilders.get("/allEmployers")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("pracownik"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].surName").value("pracownik"));
    }

    @Test
    void addStaff_withValidType() throws Exception {
        int type = 0;

        Mockito.when(mainService.saveStaff(type)).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.post("/addStaff/{type}", type)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void addStaff_withInvalidType() throws Exception {
        int type = 2;

        Mockito.when(mainService.saveStaff(type)).thenReturn(false);

        mockMvc.perform(MockMvcRequestBuilders.post("/addStaff/{type}", type)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}