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

    public void saveStaff(int type) {
        if(!checkValue(type)) return;

        switch (type) {
            case 0 -> {
                Employer employer = new Employer("imie", "nazwisko");
                employerRepo.save(employer);
            }
            case 1 -> {
                Employee employee = new Employee("imie", "nazwisko");
                employeeRepo.save(employee);
            }
        }

    }


    private boolean checkValue(int type){
        return type == 0 || type == 1;
    }
}

