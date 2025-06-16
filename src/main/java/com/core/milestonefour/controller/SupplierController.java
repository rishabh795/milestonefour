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
import com.core.milestonefour.model.Supplier;
import com.core.milestonefour.service.SupplierService;

@RestController
@RequestMapping("/api")
public class SupplierController 
{
	@Autowired
	SupplierService supplierService;
	
	@GetMapping("/suppliers")
	public ResponseEntity<List<Supplier>> gettingAllSupplier() throws InvalidDataException, ResourceNotFoundException, Exception
	{
		try
		{
			List<Supplier> res = supplierService.getAllSupplier();
			return new ResponseEntity<List<Supplier>>(res, HttpStatus.OK);
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
	
	@PostMapping("/suppliers")
	public ResponseEntity<Supplier> creatingSupplier(@RequestBody Supplier supplier) throws InvalidDataException, ResourceNotFoundException, Exception
	{
		try
		{
			Supplier res = supplierService.addSupplier(supplier);
			return new ResponseEntity<Supplier>(res, HttpStatus.OK);
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
	
	@GetMapping("/suppliers/{id}")
	public ResponseEntity<Supplier> gettingSupplierById(@PathVariable Long id) throws InvalidDataException, ResourceNotFoundException, Exception
	{
		try
		{
			Supplier res = supplierService.getSupplierById(id);
			return new ResponseEntity<Supplier>(res, HttpStatus.OK);
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
	
	@PutMapping("/suppliers/{id}")
	public ResponseEntity<Supplier> updatingSupplier(@PathVariable Long id, @RequestBody Supplier supplier) throws InvalidDataException, ResourceNotFoundException, Exception
	{
		try
		{
			Supplier res = supplierService.updateSupplierById(id, supplier);
			return new ResponseEntity<Supplier>(res, HttpStatus.OK);
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
	
	@DeleteMapping("/suppliers/{id}")
	public ResponseEntity<String> deletingSupplierById(@PathVariable Long id) throws InvalidDataException, ResourceNotFoundException, Exception
	{
		try
		{
			String res = supplierService.deletingSupplierById(id);
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
}
