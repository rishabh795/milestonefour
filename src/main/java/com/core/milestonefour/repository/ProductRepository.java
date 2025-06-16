package com.core.milestonefour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.core.milestonefour.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{
	@Query("select p from Product p where p.category.id =:categoryId")
	public List<Product> findAllByCategoryId(@Param("categoryId") Long categoryId);
	
	@Query("select p from Product p where p.supplier.id =:supplierId")
	public List<Product> findAllBySupplierId(@Param("supplierId") Long supplierId);	
}
