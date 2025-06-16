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
import com.core.milestonefour.model.Category;
import com.core.milestonefour.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController 
{
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/categories")
	public ResponseEntity<List<Category>> gettingAllCategory() throws InvalidDataException, ResourceNotFoundException,Exception
	{
		try
		{
			List<Category> res = categoryService.getAllCategory();
			return new ResponseEntity<List<Category>>(res, HttpStatus.OK);
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
	
	@PostMapping("/categories") 
	public ResponseEntity<Category> creatingCategory(@RequestBody Category category) throws InvalidDataException, ResourceNotFoundException, Exception
	{
		try
		{
			Category res = categoryService.addCategory(category);
			return new ResponseEntity<Category>(res, HttpStatus.OK);
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
	
	@GetMapping("/categories/{id}")
	public ResponseEntity<Category> gettingCategoryById(@PathVariable Long id)  throws InvalidDataException, ResourceNotFoundException, Exception
	{
		try
		{
			Category res = categoryService.getCategoryById(id);
			return new ResponseEntity<Category>(res, HttpStatus.OK);
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
	
	@PutMapping("/categories/{id}")
	public ResponseEntity<Category> updatingCategory(@PathVariable Long id, @RequestBody Category category) throws InvalidDataException, ResourceNotFoundException, Exception
	{
		try
		{
			Category res = categoryService.updateCategoryById(id, category);
			return new ResponseEntity<Category>(res, HttpStatus.OK);
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
	
	@DeleteMapping("/categories/{id}")
	public ResponseEntity<String> deletingCategoryById(@PathVariable Long id)  throws InvalidDataException, ResourceNotFoundException, Exception
	{
		try
		{
			String res = categoryService.deletingCategoryById(id);
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
