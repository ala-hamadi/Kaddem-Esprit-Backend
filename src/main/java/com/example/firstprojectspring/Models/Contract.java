package com.example.firstprojectspring.Models;

import com.example.firstprojectspring.Models.Enums.Specialty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
public class Contract implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContract;
    @Temporal(TemporalType.DATE)
    private Date contractStartDate;
    @Temporal(TemporalType.DATE)
    private Date contractEndDate;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;
    private boolean archived;
    private int contractAmount;

    @ManyToOne
    @JsonIgnore
    private Student student;
}
