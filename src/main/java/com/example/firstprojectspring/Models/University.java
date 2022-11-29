package com.example.firstprojectspring.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUniv;
    private String nameUniv;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Department> departments;


}
