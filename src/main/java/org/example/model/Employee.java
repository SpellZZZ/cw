package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surName;


    public Employee(){}

    public Employee(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }
}