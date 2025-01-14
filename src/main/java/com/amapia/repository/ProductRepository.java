package com.amapia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amapia.entity.Amap;
import com.amapia.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    List<Product> findByIsActiveTrue();

    @Query("SELECT p FROM Product p WHERE p.producer.producer_id = :producerId")
    List<Product> findByProducerId(@Param("producerId") Long producerId);
    
    @Query("SELECT p FROM Product p WHERE p.producer.member.amap = :amap")
    List<Product> findProductsByAmap(@Param("amap") Amap amap);
    
    @Query("SELECT p FROM Product p WHERE p.producer.member.amap = :amap ORDER BY p.id DESC")
    List<Product> findTop2ByAmapOrderByIdDesc(@Param("amap") Amap amap);


}
