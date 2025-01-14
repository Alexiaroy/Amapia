package com.amapia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amapia.entity.Amap;
import com.amapia.entity.Producer;


/**
 * This interface provides CRUD operations for the Producer entity by interacting with
 * the database. 
 *
 * It eliminates the need to write manual SQL queries by extending 
 * the JpaRepository interface, which provides built-in methods 
 * for common database operations.
 * 
 * @author Siham
 */

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long>{

	List<Producer> findAllByMember_Amap(Amap amap);


}