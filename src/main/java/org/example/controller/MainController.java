package org.example.controller;


import org.example.dao.EmployeeRepo;
import org.example.dao.EmployerRepo;
import org.example.model.Employee;
import org.example.model.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    private final EmployerRepo employerRepo;
    private final EmployeeRepo employeeRepo;

    @Autowired
    MainController(EmployerRepo employerRepo,
                   EmployeeRepo employeeRepo){
        this.employerRepo = employerRepo;
        this.employeeRepo = employeeRepo;
    }


    @GetMapping("/allEmployees")
    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }
    @GetMapping("/allEmployers")
    public List<Employer> getEmployers() {
        return employerRepo.findAll();
    }


}
