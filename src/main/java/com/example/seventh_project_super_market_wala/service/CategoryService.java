package com.example.seventh_project_super_market_wala.service;

import java.util.List;
import com.example.seventh_project_super_market_wala.model.Category;

public interface CategoryService {
	//it will provide GUIDE to the CONTROLLER :information
	//and will provide ASSISTANCE / blueprint to implement class.
	
	
    //get Categories
	public List<Category> getCategories();
	public Category getCategory(Long categoryId);
	
    //post Category
	public String addCategory(Category category);
	
	//delete category
	public String deleteCategory(Long categoryId);
	
    //put category 
	public String updateCategory(Long categoryId, Category category);
}