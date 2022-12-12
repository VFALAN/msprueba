package com.vf.nach.msprueba.repository;

import com.vf.nach.msprueba.model.entity.EmployeeEntity;
import com.vf.nach.msprueba.model.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

    @Query("select e from EmployeeEntity e where e.job = :job")
    List<EmployeeEntity> findByJob(@Param("job") JobEntity pJobEntity);
}
