package com.core.milestonefour.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import com.core.milestonefour.model.Product;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application-test.properties")
public class ProductRepositoryTest 
{
	private Product product;
	private Product productSaved;
	
	@Autowired
	ProductRepository productRepository;
	
	@BeforeEach
	public void setUp()
	{
		product = new Product();
		product.setName("Ultra Wide TV");
		product.setDescription("One of the widest TV's");
		product.setPrice(Double.valueOf(20000.50));
		productSaved = productRepository.save(product);
	}
	
	@Test
	public void testSaveProduct()
	{
		assertNotNull(productSaved);
		assertEquals(product.getName(), productSaved.getName());
		assertEquals(product.getDescription(), productSaved.getDescription());
		assertEquals(product.getPrice(), productSaved.getPrice());
	}
	
	@Test
	public void testFindProduct()
	{
		Product foundProduct = productRepository.findById(product.getId()).get();
		assertNotNull(foundProduct);
		assertEquals(product.getName(), foundProduct.getName());
		assertEquals(product.getDescription(), foundProduct.getDescription());
		assertEquals(product.getPrice(), foundProduct.getPrice());
	}
	
	@Test
	public void testDeleteProduct()
	{
		productRepository.deleteById(product.getId());
		Optional<Product> foundProductAfterDeletion = productRepository.findById(product.getId());
		assertThat(foundProductAfterDeletion).isNotPresent();
	}
}
