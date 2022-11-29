package com.example.firstprojectspring.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDept;
    private String nameDept;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "department")
    @JsonIgnore
    private Set<Student> students;
}
