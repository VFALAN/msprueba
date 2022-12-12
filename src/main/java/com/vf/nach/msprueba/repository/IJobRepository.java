package com.vf.nach.msprueba.repository;

import com.vf.nach.msprueba.model.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJobRepository extends JpaRepository<JobEntity, Integer> {
}
