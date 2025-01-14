package com.amapia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;






import com.amapia.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{ 


	List<Order> findAllByAmapId(Long amapId);
	@Query("SELECT p FROM Order p WHERE p.member.member_id = null")
	List<Order> findAllforAmapia();
}
