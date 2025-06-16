package com.core.milestonefour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.milestonefour.exception.InvalidDataException;
import com.core.milestonefour.exception.ResourceNotFoundException;
import com.core.milestonefour.model.Category;
import com.core.milestonefour.repository.CategoryRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryService 
{
	@Autowired
	CategoryRepository categoryRepository;
	
	public List<Category> getAllCategory()
	{
		return categoryRepository.findAll();
	}
	
	public Category addCategory(Category category)
	{
		return categoryRepository.save(category);
	}
	
	public Category getCategoryById(Long id)
	{
		if(id == null)
		{
			throw new InvalidDataException("invalid data - id");
		}
		Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
		return category;
	}
	
	public Category updateCategoryById(Long id, Category newReq)
	{
		if(id == null)
		{
			throw new InvalidDataException("invalid data - id");
		}
		Category inDB = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));

		inDB.setName(newReq.getName());
		return categoryRepository.save(inDB);
	}
	
	public String deletingCategoryById(Long id)
	{
		if(id == null)
		{
			throw new InvalidDataException("invalid data - id");
		}
		Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
		categoryRepository.delete(category);
		return "Successfully Deleted Category having ID "+ id + ".";
	}
}
