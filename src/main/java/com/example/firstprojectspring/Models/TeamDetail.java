package com.example.firstprojectspring.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class TeamDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTeamDetail;
    private int room;
    private String subject;

    @OneToOne(mappedBy = "teamDetail")
    private Team team;
}
