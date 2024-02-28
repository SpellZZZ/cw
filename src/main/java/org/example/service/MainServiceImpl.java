package org.example.service;


import org.example.dao.EmployeeRepo;
import org.example.dao.EmployerRepo;
import org.example.model.Employee;
import org.example.model.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainServiceImpl implements MainService {


    private final EmployerRepo employerRepo;
    private final EmployeeRepo employeeRepo;

    @Autowired
    MainServiceImpl(EmployerRepo employerRepo,
                   EmployeeRepo employeeRepo){
        this.employerRepo = employerRepo;
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public List<Employer> getEmployers() {
        return employerRepo.findAll();
    }


    public void save() {

    }
}

