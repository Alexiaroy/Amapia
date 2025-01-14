package com.amapia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amapia.entity.Individual;

@Repository
public interface IndividualRepository extends JpaRepository<Individual, Long>{

}
