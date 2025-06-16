package com.core.milestonefour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.milestonefour.exception.InvalidDataException;
import com.core.milestonefour.exception.ResourceNotFoundException;
import com.core.milestonefour.model.Category;
import com.core.milestonefour.model.Product;
import com.core.milestonefour.model.Supplier;
import com.core.milestonefour.repository.CategoryRepository;
import com.core.milestonefour.repository.ProductRepository;
import com.core.milestonefour.repository.SupplierRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService 
{
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	SupplierRepository supplierRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAllProduct()
	{
		return productRepository.findAll();
	}
	
	public Product addProduct(Product product)
	{
		Category category = categoryRepository.findById(product.getCategory().getId()).orElseThrow(() -> new ResourceNotFoundException("not found"));
		Supplier supplier = supplierRepository.findById(product.getCategory().getId()).orElseThrow(() -> new ResourceNotFoundException("not found"));
		product.setCategory(category);
		product.setSupplier(supplier);
		return productRepository.save(product);
	}
	
	public Product getProductById(Long id)
	{
		if(id == null)
		{
			throw new InvalidDataException("invalid data - id");
		}
		Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
		return product;
	}
	
	public Product updateProductById(Long id, Product newReq)
	{
		if(id == null)
		{
			throw new InvalidDataException("invalid data - id");
		}
		Product inDB = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));

		inDB.setName(newReq.getName());
		inDB.setDescription(newReq.getDescription());
		inDB.setPrice(newReq.getPrice());
		Category category = categoryRepository.findById(inDB.getCategory().getId()).orElseThrow(() -> new ResourceNotFoundException("not found"));
		Supplier supplier = supplierRepository.findById(inDB.getCategory().getId()).orElseThrow(() -> new ResourceNotFoundException("not found"));
		newReq.setCategory(category);
		newReq.setSupplier(supplier);
		return productRepository.save(inDB);
	}
	
	public String deletingProductById(Long id)
	{
		if(id == null)
		{
			throw new InvalidDataException("invalid data - id");
		}
		Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
		productRepository.delete(product);
		return "Successfully Deleted Product having ID "+ id + ".";
	}
	
	public List<Product> getAllProductByCategoryId(Long categoryId)
	{
		if(categoryId == null)
		{
			throw new InvalidDataException("invalid data - categoryid");
		}
		return productRepository.findAllByCategoryId(categoryId);
	}
	
	public List<Product> getAllProductBySupplierId(Long supplierId)
	{
		if(supplierId == null)
		{
			throw new InvalidDataException("invalid data - Supplier id");
		}
		return productRepository.findAllBySupplierId(supplierId);
	}
}
