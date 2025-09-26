package com.example.seventh_project_super_market_wala.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.seventh_project_super_market_wala.model.Category;
import com.example.seventh_project_super_market_wala.repo.CategoryRepository;
import com.example.seventh_project_super_market_wala.exception.NotFoundException;

	@Service
	public class CategoryServiceImplementation implements CategoryService {

	    @Autowired
	    private CategoryRepository categoryRepository; // Repository inject की

	    @Override
	    public List<Category> getCategories() {
	        return categoryRepository.findAll(); // DB से data लाओ
	    }

	    @Override
	    public Category getCategory(Long categoryId) {
	        return categoryRepository.findById(categoryId)
	                .orElseThrow(() -> new NotFoundException("Category with id " + categoryId + " not found"));
	    }

	    @Override
	    public String addCategory(Category category) {
	        categoryRepository.save(category); // DB में save करो
	        return "Category with id: " + category.getCategoryId() + " added successfully!";
	    }

	    @Override
	    public String deleteCategory(Long categoryId) {
	        Category existing = getCategory(categoryId);
	        categoryRepository.delete(existing); // DB से delete करो
	        return "Category deleted successfully!";
	    }

	    @Override
	    public String updateCategory(Long categoryId, Category category) {
	        Category existing = getCategory(categoryId);
	        existing.setCategoryName(category.getCategoryName());
	        categoryRepository.save(existing); // DB में update करो
	        return "Category updated successfully!";
	    }
	}