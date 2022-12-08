package com.example.firstprojectspring.Models;

import com.example.firstprojectspring.Models.Enums.Level;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTeam;
    private String nameTeam;
    private Level level;

    @ManyToMany(mappedBy="teams", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Student> students;

    @OneToOne
    private TeamDetail teamDetail;

}
