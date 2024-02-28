package org.example.controller;


import org.example.model.Employee;
import org.example.model.Employer;
import org.example.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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


    @GetMapping("/addStaff/{type}")
    public void addStaff(@PathVariable int type) {
        mainService.saveStaff(type);
    }




}
