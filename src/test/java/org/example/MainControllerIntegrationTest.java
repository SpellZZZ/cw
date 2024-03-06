package org.example;

import org.example.controller.MainController;
import org.example.model.Employee;
import org.example.model.Employer;
import org.example.service.MainService;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class MainControllerIntegrationTest {

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
        Mockito.when(mainService.getEmployees()).thenReturn(employees);

        List<Employee> result = mainController.getEmployees();

        Assertions.assertEquals(employees.size(), result.size());
        Mockito.verify(mainService, Mockito.times(1)).getEmployees();
    }

    @Test
    void getEmployers() {

        List<Employer> employers = new ArrayList<>();
        employers.add(new Employer("pracownik", "pracownik"));
        employers.add(new Employer("pracownik", "pracownik"));
        Mockito.when(mainService.getEmployers()).thenReturn(employers);

        List<Employer> result = mainController.getEmployers();

        Assertions.assertEquals(employers.size(), result.size());
        Mockito.verify(mainService, Mockito.times(1)).getEmployers();
    }

    @Test
    void addStaff_withValidType() {

        int type = 0;

        Mockito.when(mainService.saveStaff(type)).thenReturn(true);


        ResponseEntity<String> responseEntity = mainController.addStaff(type);

        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Mockito.verify(mainService, Mockito.times(1)).saveStaff(type);
    }

    @Test
    void addStaff_withInvalidType() {
        int type = 2;

        Mockito.when(mainService.saveStaff(type)).thenReturn(false);

        ResponseEntity<String> responseEntity = mainController.addStaff(type);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode()); // Assuming a generic OK response
        Mockito.verify(mainService, Mockito.times(1)).saveStaff(type);
    }
}
