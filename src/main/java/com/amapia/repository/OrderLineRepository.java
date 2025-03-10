package com.amapia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.amapia.entity.Order;

import com.amapia.entity.OrderLine;


@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long>{ 

}
