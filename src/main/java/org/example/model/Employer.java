package org.example.model;


import jakarta.persistence.*;


@Entity
@Table(name = "employers")
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surName;

    public Employer(){}

    public Employer(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }
}
