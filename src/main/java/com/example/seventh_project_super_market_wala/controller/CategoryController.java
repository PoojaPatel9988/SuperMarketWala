package com.example.seventh_project_super_market_wala.controller;

import java.util.List;

import java.util.ArrayList;
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
		ResponseEntity<List<Category>> getCategories(){
			List<Category> categories = categoryService.getCategories();
			return ResponseEntity.ok().body(categories);
		}
		
		@GetMapping("/categories/g/{categoryId}")
        ResponseEntity<Category> getCategory( @PathVariable Long categoryId){
			Category cat = categoryService.getCategory(categoryId);
			return ResponseEntity.ok().body(cat);
		}
		
		@PostMapping("/categories/p")
		ResponseEntity<String> addCategory(@RequestBody Category category){
			String message = categoryService.addCategory(category);
			return ResponseEntity.accepted().body(message);
		}
	    
		@DeleteMapping("/categories/d/{catId}")
		ResponseEntity<String> removeCategory(@PathVariable("catId") Long categoryId) {
			String message = categoryService.deleteCategory(categoryId);
			return ResponseEntity.ok().body(message);
		}
		
		@PutMapping("/categories/u/{categoryId}")
		ResponseEntity<String> updateCategory( @PathVariable("categoryId")Long categoryId, @RequestBody Category category)
		{
			String message = categoryService.updateCategory(categoryId, category);
			return ResponseEntity.ok().body(message);
		}
}
