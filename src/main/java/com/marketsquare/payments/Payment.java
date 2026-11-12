package com.marketsquare.payments;

public class Payment {
   private String orderId;
   private double amount;
   private  String idempotentKey;
   private String paymentId;



    public String getOrderId() {return orderId;}
    public void setOrderId(String orderId) {this.orderId = orderId;}

    public double getAmount() {return amount;}
    public void setAmount(double amount) {this.amount = amount;}

    public String getIdempotentKey() {return idempotentKey;}
    public void setIdempotentKey(String idempotentKey) {this.idempotentKey = idempotentKey;}

    public String getPaymentId() {return paymentId;}
    public void setPaymentId(String paymentId) {this.paymentId = paymentId;}
}

