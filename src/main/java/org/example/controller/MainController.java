package org.example.controller;


import org.example.model.Employee;
import org.example.model.Employer;
import org.example.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    private final MainService mainService;

    @Autowired
    MainController(MainService mainService){
        this.mainService = mainService;
    }


    @GetMapping("/allEmployees")
    @ResponseBody
    public List<Employee> getEmployees() {
        return mainService.getEmployees();
    }
    @GetMapping("/allEmployers")
    @ResponseBody
    public List<Employer> getEmployers() {
        return mainService.getEmployers();
    }


    @PostMapping("/addStaff/{type}")
    public ResponseEntity<String> addStaff(@PathVariable int type) {
        if(mainService.saveStaff(type)) return ResponseEntity.ok("Ok");
        else return ResponseEntity.badRequest().body("Invalid staff type.");
    }




}
