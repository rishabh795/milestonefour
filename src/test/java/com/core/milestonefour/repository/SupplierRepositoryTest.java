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

import com.core.milestonefour.model.Supplier;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application-test.properties")
public class SupplierRepositoryTest 
{
	private Supplier supplier;
	private Supplier supplierSaved;
	
	@Autowired
	SupplierRepository supplierRepository;
	
	@BeforeEach
	public void setUp()
	{
		supplier = new Supplier();
		supplier.setName("Supplier1");
		supplier.setAddress("Bangalore");
		supplier.setContact("9910236387");
		supplierSaved = supplierRepository.save(supplier);
	}
	
	@Test
	public void testSaveSupplier()
	{
		assertNotNull(supplierSaved);
		assertEquals(supplier.getName(), supplierSaved.getName());
		assertEquals(supplier.getAddress(), supplierSaved.getAddress());
		assertEquals(supplier.getContact(), supplierSaved.getContact());
	}
	
	@Test
	public void testFindSupplier()
	{
		Supplier foundSupplier = supplierRepository.findById(supplier.getId()).get();
		assertNotNull(foundSupplier);
		assertEquals(supplier.getName(), foundSupplier.getName());
		assertEquals(supplier.getAddress(), foundSupplier.getAddress());
		assertEquals(supplier.getContact(), foundSupplier.getContact());
	}
	
	@Test
	public void testDeleteSupplier()
	{
		supplierRepository.deleteById(supplier.getId());
		Optional<Supplier> foundSupplierAfterDeletion = supplierRepository.findById(supplier.getId());
		assertThat(foundSupplierAfterDeletion).isNotPresent();
	}
}
