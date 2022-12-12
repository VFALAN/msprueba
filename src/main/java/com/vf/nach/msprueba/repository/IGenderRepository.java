package com.vf.nach.msprueba.repository;

import com.vf.nach.msprueba.model.entity.GenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenderRepository extends JpaRepository<GenderEntity, Integer> {
}
