package com.example.seventh_project_super_market_wala.controller;

import java.util.List;
import java.net.CacheResponse;
import java.util.ArrayList;

import com.example.seventh_project_super_market_wala.dto.CategoryDTO;
import com.example.seventh_project_super_market_wala.model.Category;
import com.example.seventh_project_super_market_wala.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.seventh_project_super_market_wala.model.Category;

@RestController
@RequestMapping("api/v1")
public class CategoryController {
	
	//DEPENDENCY INJECTION
		@Autowired
		private CategoryService categoryService;
		
		@GetMapping("/categories")
		ResponseEntity<CategoryDTO> getCategories()
		{
			CategoryDTO categories = categoryService.getCategories();
			return ResponseEntity.ok().body(categories);
		}			
	
		//I want to return single category based on id to the user.
		@GetMapping("/categories/g/{categoryId}")
        ResponseEntity<Category> getCategory( @PathVariable Long categoryId)
		{
 			Category cat = categoryService.getCategory(categoryId);
  			return ResponseEntity.ok().body(cat);
		}
		
		@PostMapping("/categories/p")
		ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO categoryDTO)
		{
			CategoryDTO addCategory = categoryService.addCategory(categoryDTO);
			return ResponseEntity.accepted().body(addCategory);
			
		}
	    
		@DeleteMapping("/categories/d/{catId}")
		ResponseEntity<CategoryDTO> removeCategory(@PathVariable("catId") Long categoryId)
		{
			CategoryDTO deleteCategory = categoryService.deleteCategory(categoryId);
			return ResponseEntity.ok().body(deleteCategory);
		}
		
		@PutMapping("/categories/u/{categoryId}")
		ResponseEntity<CategoryDTO> updateCategory( @PathVariable("categoryId")Long categoryId, @RequestBody Category category)
		{
			CategoryDTO updateCategory = categoryService.updateCategory(categoryId, category);
			return ResponseEntity.ok().body(updateCategory);
		}
}
