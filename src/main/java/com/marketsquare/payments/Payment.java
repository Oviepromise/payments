package com.marketsquare.payments;

public class Payment {
    private String paymentId;
    private String orderId;
    private double amount;
    private String method;
    private String status;

    public Payment(String paymentId, String orderId, double amount, String method) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.amount = amount;
        this.method = method;
        this.status = "pending";
    }

    public boolean checkTransaction() {
        if (this.amount <= 0) {
            status = "Failed";
            return false;
        } else {
            status = "Success";
            return true;
        }
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }
}

