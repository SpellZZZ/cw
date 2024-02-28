package org.example.dao;

import org.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository <Employee, Long> {
    Employee findByName(String name);
    Employee findBySurname(String surname);
}
