package org.example.controller;


import org.example.dao.EmployeeRepo;
import org.example.dao.EmployerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private EmployerRepo employerRepo;
    private EmployeeRepo employeeRepo;

    @Autowired
    MainController(){

    }
}
