package com.core.milestonefour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.core.milestonefour.exception.InvalidDataException;
import com.core.milestonefour.exception.ResourceNotFoundException;
import com.core.milestonefour.model.Product;
import com.core.milestonefour.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController 
{
	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> gettingAllProduct() throws InvalidDataException, ResourceNotFoundException, Exception
	{
		try
		{
			List<Product> res = productService.getAllProduct();
			return new ResponseEntity<List<Product>>(res, HttpStatus.OK);
		}
		catch(InvalidDataException e)
		{
			throw new InvalidDataException(e.getMessage());
		}
		catch(ResourceNotFoundException e)
		{
			throw new InvalidDataException(e.getMessage());
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	
	@PostMapping("/products")
	public ResponseEntity<Product> creatingProduct(@RequestBody Product product) throws InvalidDataException, ResourceNotFoundException, Exception
	{
		try
		{
			Product res = productService.addProduct(product);
			return new ResponseEntity<Product>(res, HttpStatus.OK);
		}
		catch(InvalidDataException e)
		{
			throw new InvalidDataException(e.getMessage());
		}
		catch(ResourceNotFoundException e)
		{
			throw new InvalidDataException(e.getMessage());
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> gettingProductById(@PathVariable Long id) throws InvalidDataException, ResourceNotFoundException, Exception
	{
		try
		{
			Product res = productService.getProductById(id);
			return new ResponseEntity<Product>(res, HttpStatus.OK);
		}
		catch(InvalidDataException e)
		{
			throw new InvalidDataException(e.getMessage());
		}
		catch(ResourceNotFoundException e)
		{
			throw new InvalidDataException(e.getMessage());
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updatingProduct(@PathVariable Long id, @RequestBody Product product) throws InvalidDataException, ResourceNotFoundException, Exception
	{
		try
		{
			Product res = productService.updateProductById(id, product);
			return new ResponseEntity<Product>(res, HttpStatus.OK);
		}
		catch(InvalidDataException e)
		{
			throw new InvalidDataException(e.getMessage());
		}
		catch(ResourceNotFoundException e)
		{
			throw new InvalidDataException(e.getMessage());
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> deletingProductById(@PathVariable Long id) throws InvalidDataException, ResourceNotFoundException, Exception
	{
		try
		{
			String res = productService.deletingProductById(id);
			return new ResponseEntity<String>(res, HttpStatus.OK);
		}
		catch(InvalidDataException e)
		{
			throw new InvalidDataException(e.getMessage());
		}
		catch(ResourceNotFoundException e)
		{
			throw new InvalidDataException(e.getMessage());
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	
	@GetMapping("/products/category/{categoryId}")
	public ResponseEntity<List<Product>> gettingAllProductByCategoryId(@PathVariable Long categoryId) throws InvalidDataException, ResourceNotFoundException, Exception
	{
		try
		{
			List<Product> res = productService.getAllProductByCategoryId(categoryId);
			return new ResponseEntity<List<Product>>(res, HttpStatus.OK);
		}
		catch(InvalidDataException e)
		{
			throw new InvalidDataException(e.getMessage());
		}
		catch(ResourceNotFoundException e)
		{
			throw new InvalidDataException(e.getMessage());
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	
	@GetMapping("/products/supplier/{supplierId}")
	public ResponseEntity<List<Product>> gettingAllProductBySupplierId(@PathVariable Long supplierId) throws InvalidDataException, ResourceNotFoundException, Exception
	{
		try
		{
			List<Product> res = productService.getAllProductBySupplierId(supplierId);
			return new ResponseEntity<List<Product>>(res, HttpStatus.OK);
		}
		catch(InvalidDataException e)
		{
			throw new InvalidDataException(e.getMessage());
		}
		catch(ResourceNotFoundException e)
		{
			throw new InvalidDataException(e.getMessage());
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
}
