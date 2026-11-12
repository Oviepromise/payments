package com.marketsquare.payments;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public Payment createPayment(@RequestBody PaymentRequest request) {
        return paymentService.processPayment(
                request.orderId,
                request.amount,
                request.idempotentKey
        );
    }

    public static class PaymentRequest {
        public String orderId;
        public double amount;
        public String idempotentKey;
    }
}