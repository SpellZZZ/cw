package org.example.controller;


import org.example.dao.EmployeeRepo;
import org.example.dao.EmployerRepo;
import org.example.model.Employee;
import org.example.model.Employer;
import org.example.service.MainService;
import org.example.service.MainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    private final MainService mainService;

    @Autowired
    MainController(MainService mainService){
        this.mainService = mainService;
    }


    @GetMapping("/allEmployees")
    public List<Employee> getEmployees() {
        return mainService.getEmployees();
    }
    @GetMapping("/allEmployers")
    public List<Employer> getEmployers() {
        return mainService.getEmployers();
    }


}
