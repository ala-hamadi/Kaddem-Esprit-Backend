package com.example.firstprojectspring.Models;

import com.example.firstprojectspring.Models.Enums.StudyOption;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
public class Student implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long idStudent;
   private String firstName;
   private String lastName;
   @Enumerated(EnumType.STRING)
   private StudyOption option;

   @OneToMany(cascade = CascadeType.ALL,mappedBy="student")
   private Set<Contract> contracts;

   @ManyToOne
   private Department department;

   @ManyToMany(cascade = CascadeType.ALL)

   private Set<Team> teams;
}
