package com.example.seventh_project_super_market_wala.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.seventh_project_super_market_wala.model.Category;
import com.example.seventh_project_super_market_wala.exception.NotFoundException;
@Service
public class CategoryServiceImplementation implements CategoryService{
	List<Category> categories = new ArrayList<>();

	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return categories;
	}
	
	@Override
	public String addCategory(Category category) {
		// TODO Auto-generated method stub
		categories.add(category);
		return "Category with id: " + category.getCategoryId() + "Added successfully!";
	}
	@Override
	public String deleteCategory(Long categoryId) {
		//Long id=Long.valueof(categoryId);
		Category categoryToBeRemoved = findByIdOrThrow(categoryId);
		categories.remove(categoryToBeRemoved);
		return "Delete categogry successfully!";
	}
	@Override
	public String updateCategory(Long categoryId, Category category) {
		Category existingCategory = findByIdOrThrow(categoryId);
		int index = categories.indexOf(existingCategory);
		categories.set(index, category);
		return "category with id " + category.getCategoryId() + " update successfully!";
	}
	
	@Override
	public Category getCategory(Long categoryId) {
		// TODO Auto-generated method stub
		return findByIdOrThrow(categoryId);
	}
	
	//helper method
	private Category findByIdOrThrow(Long id)
	{
		Optional<Category> opt = categories.stream()
				.filter(c -> c.getCategoryId() != null && c.getCategoryId().equals(id))
				.findFirst();
		return opt.orElseThrow(()->new NotFoundException("Category with id " + id +  " not found"));
		
	}
}

