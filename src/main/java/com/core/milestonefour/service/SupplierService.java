package com.core.milestonefour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.milestonefour.exception.InvalidDataException;
import com.core.milestonefour.exception.ResourceNotFoundException;
import com.core.milestonefour.model.Supplier;
import com.core.milestonefour.repository.SupplierRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SupplierService 
{
	@Autowired
	SupplierRepository supplierRepository;
	
	public List<Supplier> getAllSupplier()
	{
		return supplierRepository.findAll();
	}
	
	public Supplier addSupplier(Supplier supplier)
	{
		return supplierRepository.save(supplier);
	}
	
	public Supplier getSupplierById(Long id)
	{
		if(id == null)
		{
			throw new InvalidDataException("invalid data - id");
		}
		Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
		return supplier;
	}
	
	public Supplier updateSupplierById(Long id, Supplier newReq)
	{
		if(id == null)
		{
			throw new InvalidDataException("invalid data - id");
		}
		Supplier inDB = supplierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));

		inDB.setName(newReq.getName());
		inDB.setContact(newReq.getContact());
		inDB.setAddress(newReq.getAddress());
		return supplierRepository.save(inDB);
	}
	
	public String deletingSupplierById(Long id)
	{
		if(id == null)
		{
			throw new InvalidDataException("invalid data - id");
		}
		Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
		supplierRepository.delete(supplier);
		return "Successfully Deleted Supplier having ID "+ id + ".";
	}
}
