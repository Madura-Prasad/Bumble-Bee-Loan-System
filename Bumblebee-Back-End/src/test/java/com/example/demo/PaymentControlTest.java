package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Payment;
import com.example.demo.repository.PaymentRepository;

@SpringBootTest
public class PaymentControlTest {

	@Autowired
	PaymentRepository paymentRepository;

	@Test
	public void testSavePayment() {
		Payment payment = new Payment();
		payment.setId(1L);
		payment.setName("Uthpala");
		payment.setAddress("Moratuwa");
		payment.setMobile("0783587714");
		payment.setNote("No");
		payment.setTotal("1500");
		payment.setDividedAmount("1500");
		paymentRepository.save(payment);
		assertNotNull(paymentRepository.findById(1L).get());
	}

	@Test
	public void testAllData() {
		List<Payment> list1 = paymentRepository.findAll();
		assertThat(list1).size().isGreaterThan(0);
	}
}
