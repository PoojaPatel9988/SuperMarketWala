package com.example.seventh_project_super_market_wala.service;

import java.util.List;
import com.example.seventh_project_super_market_wala.dto.CategoryDTO;
import com.example.seventh_project_super_market_wala.dto.CategoryResponse;
import com.example.seventh_project_super_market_wala.model.Category;

public interface CategoryService {
	//it will provide GUIDE to the CONTROLLER :information
	//and will provide ASSISTANCE / blueprint to implement class.
	
	
    //get Categories
	public CategoryResponse getCategories(int pageNumber, int size);
	public Category getCategory(Long categoryId);
	
    //post Category
    public CategoryDTO addCategory(CategoryDTO categoryDTO);
	//delete category
	public CategoryDTO deleteCategory(Long categoryId);
	
    //put category 
	public CategoryDTO updateCategory(Long categoryId, CategoryDTO categoryDTO);

}