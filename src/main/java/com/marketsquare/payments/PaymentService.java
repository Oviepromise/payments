package com.marketsquare.payments;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    private Map<String, Payment> paymentStore = new HashMap<>();

    public Payment processPayment(String orderId, double amount, String idempotentKey) {
        if (paymentStore.containsKey(idempotentKey)) {
            return paymentStore.get(idempotentKey);
        }

        Payment payment = new Payment();
        payment.setOrderId(orderId);
        payment.setAmount(amount);
        payment.setIdempotentKey(idempotentKey);
        payment.setPaymentId("PAY-" + System.currentTimeMillis());

        paymentStore.put(idempotentKey, payment);

        return payment;
    }
}
