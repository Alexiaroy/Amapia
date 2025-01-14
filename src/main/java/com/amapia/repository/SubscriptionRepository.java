package com.amapia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amapia.entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long>{

}
