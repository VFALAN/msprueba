package com.vf.nach.msprueba.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "GENDERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenderEntity {
    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;

@JsonIgnore
    @OneToMany(mappedBy = "gender")
    private List<EmployeeEntity> employeeEntityList;
}
