package com.marketsquare.payments;

public class PaymentService {

    public Payment createPayment(String orderId, double amount, String method){
        String paymentId = "PAY" + System.currentTimeMillis();
        return new Payment(paymentId, orderId, amount, method);
    }

    public boolean processPayment(Payment payment){
        return payment.checkTransaction();
    }
}
