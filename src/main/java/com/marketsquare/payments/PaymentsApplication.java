package com.marketsquare.payments;

import com.marketsquare.payments.Payment;
import com.marketsquare.payments.PaymentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentsApplication.class, args);

		PaymentService service = new PaymentService();
		Payment myPayment = service.createPayment("ORD134", 5000, "OPay");
		System.out.println(myPayment.getPaymentId());
		System.out.println(service.processPayment(myPayment));
	}
}