package com.vf.nach.msprueba.repository;

import com.vf.nach.msprueba.model.entity.EmployeeWorkedHourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeWorkedHourRepository extends JpaRepository<EmployeeWorkedHourEntity, Integer> {
}
