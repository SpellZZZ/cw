package org.example.controller;
import org.example.model.Employee;
import org.example.model.Employer;
import org.example.service.MainService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class MainControllerSpringWebTest {

    @Mock
    private MainService mainService;

    private MainController mainController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mainController = new MainController(mainService);
    }

    @Test
    void testGetEmployees_ReturnsEmployees() {
        List<Employee> employees = Arrays.asList(new Employee(/* employee data */));
        when(mainService.getEmployees()).thenReturn(employees);
        List<Employee> result = mainController.getEmployees();
        assertEquals(employees, result);

    }

    @Test
    void testGetEmployers_ReturnsEmployers() {
        // Arrange
        List<Employer> employers = Arrays.asList(new Employer(/* employer data */));
        when(mainService.getEmployers()).thenReturn(employers);

        // Act
        List<Employer> result = mainController.getEmployers();

        // Assert
        assertEquals(employers, result);
    }

    @Test
    void testAddStaff_ValidType_ReturnsOk() {
        // Arrange
        int validType = 1;
        when(mainService.saveStaff(validType)).thenReturn(true);

        // Act
        ResponseEntity<String> response = mainController.addStaff(validType);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Ok", response.getBody());
    }

    @Test
    void testAddStaff_InvalidType_ReturnsBadRequest() {
        // Arrange
        int invalidType = -1;
        when(mainService.saveStaff(invalidType)).thenReturn(false);

        // Act
        ResponseEntity<String> response = mainController.addStaff(invalidType);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Invalid staff type.", response.getBody());
    }
}
