package com.example.seventh_project_super_market_wala.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Service;

import com.example.seventh_project_super_market_wala.model.Category;
import com.example.seventh_project_super_market_wala.repo.CategoryRepository;

import ch.qos.logback.core.model.SerializeModelModel;

import com.example.seventh_project_super_market_wala.dto.CategoryDTO;
import com.example.seventh_project_super_market_wala.exception.NotFoundException;

	@Service
	public class CategoryServiceImplementation implements CategoryService {

	    @Autowired
	    private CategoryRepository categoryRepository; // Repository inject की
	    
	    @Autowired
	    private ModelMapper modelMapper;

	    @Override
	    public CategoryDTO getCategories() {
	    	ListCrudRepository<Category, Long> categoryRespository = null;
			List<Category> categories = categoryRespository.findAll();
	    	List<CategoryDTO> convertedCategories = categories.stream()
	    			.map(cat -> modelMapper.map(cat, CategoryDTO.class))
	    			.toList();
	    	
	    	CategoryDTO categoryResponse = new CategoryDTO();
	    	categoryResponse.setContent(convertedCategories);
	    	
	        return categoryResponse; // DB से data लाओ
	    }
	    
	    @Override
	    public List<CategoryDTO> getCategories() {
	        List<Category> categories = categoryRepository.findAll();
	        List<CategoryDTO> categoryDTOs = new ArrayList<>();

	        for (Category category : categories) {
	            CategoryDTO dto = modelMapper.map(category, CategoryDTO.class);
	            categoryDTOs.add(dto);
	        }

	        return categoryDTOs;
	    }

	    @Override
	    public Category getCategory(Long categoryId) {
	    	Optional<Category> category = categoryRepository.findById(categoryId);
	        return category.orElseThrow(() -> new NotFoundException("Category with id " + categoryId + " not found"));
	    }

	    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
	    	Category category = modelMapper.map(categoryDTO, Category.class);
	        categoryRepository.save(category); // DB में save करो
	        return modelMapper.map(category, CategoryDTO.class);
	    }

	    @Override
	    public CategoryDTO deleteCategory(Long categoryId) {
	    	
//	        Category existing = getCategory(categoryId);
//	        categoryRepository.delete(existing); // DB से delete करो
//	        //return "Category deleted successfully!";
//	        return category;
	    	
        Optional<Category> existingCategory = categoryRepository.findById(categoryId);
	    	
        if(existingCategory.isPresent())
    	{
    		Category c = existingCategory.get();
    		categoryRepository.delete(c);
    		return modelMapper.map(c, CategoryDTO.class);
    	}else
    	{
    		throw new NotFoundException("category not found");
    	}
	    }

	    @Override
	    public CategoryDTO updateCategory(Long categoryId, Category category) {
	    	
//	        Category existing = getCategory(categoryId);
//	        existing.setCategoryName(category.getCategoryName());
//	        categoryRepository.save(existing); // DB में update करो
//	        return "Category updated successfully!";
	    	
	    	Optional<Category> existingCategory = categoryRepository.findById(categoryId);
			
	    	if(existingCategory.isPresent())
	    	{
	    		Category c = existingCategory.get();
	    		c.setCategoryName(category.getCategoryName());
	    		categoryRepository.save(c);
	    		return modelMapper.map(c, CategoryDTO.class);
	    	}else
	    	{
	    		throw new NotFoundException("category not found");
	    	}
	    
	    }



		
	
	}