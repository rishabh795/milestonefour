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

import com.core.milestonefour.model.Category;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application-test.properties")
public class CategoryRepositoryTest 
{
	private Category category;
	private Category categorySaved;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@BeforeEach
	public void setUp()
	{
		category = new Category();
		category.setName("Electronics");
		categorySaved = categoryRepository.save(category);
	}
	
	@Test
	public void testSaveCategory()
	{
		assertNotNull(categorySaved);
		assertEquals(category.getName(), categorySaved.getName());
	}
	
	@Test
	public void testFindCategory()
	{
		Category foundCategory = categoryRepository.findById(category.getId()).get();
		assertNotNull(foundCategory);
		assertEquals(category.getName(), foundCategory.getName());
	}
	
	@Test
	public void testDeleteCategory()
	{
		categoryRepository.deleteById(category.getId());
		Optional<Category> foundCategoryAfterDeletion = categoryRepository.findById(category.getId());
		assertThat(foundCategoryAfterDeletion).isNotPresent();
	}
}
