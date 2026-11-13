package com.marketsquare.payments;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByIdempotentKey(String idempotentKey);
    Optional<Payment> findByReference(String reference);
}