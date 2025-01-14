package com.amapia.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amapia.entity.ChargeRequest;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

@Service
public class StripeService {

    @Value("${STRIPE_SECRET_KEY}")
    private String secretKey="sk_test_51QXlJBEDYGlSY25ewBfeK9wVFExAhS1RSJXi8VvwUQGHIM4mF4YnJjJkzgzFGdNipbnj7RAuEl3Ku0pXpGB8xIoc00FFdNkLoc";
    
    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }
    public Charge charge(ChargeRequest chargeRequest) 
      throws StripeException {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", chargeRequest.getAmount());
        chargeParams.put("currency","EUR");
        chargeParams.put("description", chargeRequest.getDescription());
        chargeParams.put("source", chargeRequest.getToken());
        return Charge.create(chargeParams);
    }
}