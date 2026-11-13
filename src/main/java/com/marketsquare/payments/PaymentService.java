package com.marketsquare.payments;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaystackService paystackService;

    public PaymentService(PaymentRepository paymentRepository, PaystackService paystackService) {
        this.paymentRepository = paymentRepository;
        this.paystackService = paystackService;
    }

    @Transactional
    public Payment processPayment(String orderId, double amount, String idempotentKey){
        return paymentRepository.findByIdempotentKey(idempotentKey).orElseGet (() -> {
            Payment payment = new Payment();
             payment.setReference(UUID.randomUUID().toString());
             payment.setIdempotentKey(idempotentKey);
             payment.setStatus("SUCCESS");
            return paymentRepository.save(payment);
        });
    }
}
