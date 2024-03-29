package org.example.dao;

import org.example.model.Employee;
import org.example.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepo extends JpaRepository<Employer, Long> {
    Employer findByName(String name);
    Employer findBySurName(String surname);
}
