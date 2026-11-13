package com.marketsquare.payments;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaystackService {

    @Value("${paystack.secret.key}")
    private String secretKey;

    public Map<String, Object> initializePayment(String email, double amount, String reference) {
        Map<String, Object> response = new HashMap<>();

        // For now mock — no real money
        if (secretKey.equals("sk_test_placeholder") || secretKey.isEmpty()) {
            response.put("authorization_url", "https://paystack.com/pay/mock_" + reference);
            response.put("reference", reference);
            response.put("message", "Mock Paystack - no real charge (TEST mode)");
            return response;
        }
        
        response.put("authorization_url", "https://paystack.com/pay/" + reference);
        response.put("reference", reference);
        return response;
    }
}