package com.amapia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amapia.entity.Activity;
import com.amapia.entity.Amap;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long>{

	@Query("SELECT a FROM Activity a WHERE a.producer.producer_id = :producer_id")
	List<Activity> findByProducerId(@Param("producer_id") Long producer_id);
	
	@Query("SELECT a FROM Activity a WHERE a.isActive = true")
	List<Activity> findByIsActiveTrue();
	
	@Query("SELECT a FROM Activity a WHERE a.producer.member.amap = :amap ORDER BY a.id DESC")
	List<Activity> findTop2ByAmapOrderByIdDesc(@Param("amap") Amap amap);

	
	@Query("SELECT a FROM Activity a WHERE a.producer.member.amap = :amap")
	List<Activity> findActivityByAmap(@Param("amap") Amap amap);

}
