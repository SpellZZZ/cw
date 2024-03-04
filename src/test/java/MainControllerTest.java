import org.example.Main;
import org.example.controller.MainController;
import org.example.model.Employee;
import org.example.model.Employer;
import org.example.service.MainService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MainControllerTest {

    @Mock
    private MainService mainService;

    @InjectMocks
    private MainController mainController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getEmployees() {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("pracownik", "pracownik"));
        employees.add(new Employee("pracownik", "pracownik"));
        when(mainService.getEmployees()).thenReturn(employees);

        List<Employee> result = mainController.getEmployees();

        assertEquals(employees.size(), result.size());
        verify(mainService, times(1)).getEmployees();
    }

    @Test
    void getEmployers() {

        List<Employer> employers = new ArrayList<>();
        employers.add(new Employer("pracownik", "pracownik"));
        employers.add(new Employer("pracownik", "pracownik"));
        when(mainService.getEmployers()).thenReturn(employers);

        List<Employer> result = mainController.getEmployers();

        assertEquals(employers.size(), result.size());
        verify(mainService, times(1)).getEmployers();
    }

    @Test
    void addStaff_withValidType() {

        int type = 0;

        when(mainService.saveStaff(type)).thenReturn(true);


        ResponseEntity<String> responseEntity = mainController.addStaff(type);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(mainService, times(1)).saveStaff(type);
    }

    @Test
    void addStaff_withInvalidType() {
        int type = 2;

        when(mainService.saveStaff(type)).thenReturn(false);

        ResponseEntity<String> responseEntity = mainController.addStaff(type);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode()); // Assuming a generic OK response
        verify(mainService, times(1)).saveStaff(type);
    }
}
