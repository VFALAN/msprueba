package com.vf.nach.msprueba.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table( name="EMPLOYEE_WORKED_HOURS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeWorkedHourEntity {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
private Integer id;
    @Column(name="WORKED_HOURS")
    private Integer workedHours;
    @Column(name="WORKED_DATE")
    private Date workedDate;
    @ManyToOne
    @JoinColumn(name="EMPLOYEE_ID")
    private EmployeeEntity employee;
}
