package com.vf.nach.msprueba.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EMPLOYEES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeEntity {

    @Id
    @JsonProperty
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @JsonProperty
    @Column(name = "NAME")
    private String name;
    @JsonProperty("last_name")
    @Column(name = "LAST_NAME")
    private String lastName;
    @JsonProperty
    @Column(name = "BIRTHDATE")
    private Date birthdate;
    @ManyToOne
    @JsonProperty("gender")
    @JoinColumn(name = "GENDER_ID")
    private GenderEntity gender;

    @ManyToOne
    @JsonProperty("job")
    @JoinColumn(name="JOB_ID")
    private JobEntity job;
@JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<EmployeeWorkedHourEntity> employeeWorkedHourEntityList;
}
