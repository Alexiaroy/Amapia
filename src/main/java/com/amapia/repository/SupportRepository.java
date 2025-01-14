package com.amapia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.amapia.entity.Support;

public interface SupportRepository extends JpaRepository<Support, Long>{

}
