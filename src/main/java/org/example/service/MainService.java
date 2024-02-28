package org.example.service;

import org.example.model.Employee;
import org.example.model.Employer;

import java.util.List;

public interface MainService {
    public List<Employee> getEmployees();
    public List<Employer> getEmployers();
    public void saveStaff(int type);

}
