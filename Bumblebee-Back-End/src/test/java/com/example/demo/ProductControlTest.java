package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@SpringBootTest
public class ProductControlTest {

	@Autowired
	ProductRepository productRepository;

	@Test
	public void testProductSave() {
		Product product = new Product();
		product.setId(1L);
		product.setTitle("Gaming Keyboard");
		product.setDescription("Full Keyboard Pack");
		product.setCategory("Keyboard");
		product.setPrice((long) 7500);
		product.setImage("https://www.nanotek.lk/uploads/product/1757-20230113113749-1024%20(1)%20(2).png");
		productRepository.save(product);
		assertNotNull(productRepository.findById(1L).get());
	}

	@Test
	public void testReadAllProduct() {
		List<Product> list1 = productRepository.findAll();
		assertThat(list1).size().isGreaterThan(0);
	}

	@Test
	public void testUpdateProduct() {
		Product product = productRepository.findById(1L).get();
		product.setCategory("Gaming-Keyboard");
		productRepository.save(product);
		assertNotEquals("Keyboard", productRepository.findById(1L).get().getCategory());
	}

	@Test
	public void testDelete() {
		productRepository.deleteById(1L);
		assertThat(productRepository.existsById(1L)).isFalse();
	}

}
