package com.marketsquare.payments;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderId;
    private Double amount;
    private String reference;
    @Column(unique = true)
    private String idempotentKey;
    private String status;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getOrderId() {return orderId;}
    public void setOrderId(String orderId) {this.orderId = orderId;}

    public Double getAmount() {return amount;}
    public void setAmount(Double amount) {this.amount = amount;}

    public String getReference() {return reference;}
    public void setReference(String reference) {this.reference = reference;}

    public String getIdempotentKey() {return idempotentKey;}
    public void setIdempotentKey(String idempotentKey) {this.idempotentKey = idempotentKey;}

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}

    public LocalDateTime getCreatedAt() {return createdAt;}
    public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}
}