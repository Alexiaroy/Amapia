package com.amapia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amapia.entity.Amap;
import com.amapia.entity.Basket;
import com.amapia.entity.Producer;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {
	@Query("SELECT p FROM Basket p WHERE p.producer.producer_id = :producerId")
	List<Basket> findByProducerId(Long producerId);

	@Query("SELECT p FROM Basket p WHERE p.producer.producer_id = :producerId AND isPublished = true ")
	List<Basket> findByProducerIdandPublished(Long producerId);
	
	@Query("SELECT b FROM Basket b WHERE b.producer.member.amap = :amap ORDER BY b.id DESC")
	List<Basket> findTop2ByAmapOrderByIdDesc(@Param("amap") Amap amap);

	
	@Query("SELECT b FROM Basket b WHERE b.producer.member.amap = :amap")
	List<Basket> findBasketsByAmap(@Param("amap") Amap amap);


}
