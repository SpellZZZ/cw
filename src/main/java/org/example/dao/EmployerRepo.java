package org.example.dao;

import org.example.model.Employee;
import org.example.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepo extends JpaRepository<Employer, Long> {
    Employee findByName(String name);
    Employee findBySurname(String surname);
}
