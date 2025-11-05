package com.example.seventh_project_super_market_wala.service;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Service;

import com.example.seventh_project_super_market_wala.dto.CategoryDTO;
import com.example.seventh_project_super_market_wala.dto.CategoryResponse;
import com.example.seventh_project_super_market_wala.exception.NotFoundException;
import com.example.seventh_project_super_market_wala.model.Category;
import com.example.seventh_project_super_market_wala.repo.CategoryRepository;

//import ch.qos.logback.core.model.SerializeModelModel;




	@Service
	public class CategoryServiceImplementation implements CategoryService {

	    @Autowired
	    private CategoryRepository categoryRepository; // Repository inject की
	    
	    @Autowired
	    private ModelMapper modelMapper;

	    @Override
	    public CategoryResponse getCategories(int pageNumber, int size) {
	    	Pageable pageRequest = PageRequest.of(pageNumber, size);
			Page<Category> categories = categoryRepository.findAll(pageRequest);
			
			List<CategoryDTO> convertedCategories = categories.stream()
					.map(cat -> modelMapper.map(cat, CategoryDTO.class))
					.toList();
			
			CategoryResponse categoryResponse = new CategoryResponse();
			
			categoryResponse.setContent(convertedCategories);
			categoryResponse.setTotalElement(categories.getTotalElements());
			categoryResponse.setTotalPages(categories.getTotalPages());
			categoryResponse.setNumber(categories.getNumber());
			categoryResponse.setSize(categories.getSize());
			categoryResponse.setTotalNumberOfElements(categories.getNumberOfElements());
			categoryResponse.setIslastPage(categories.isLast());
			return categoryResponse; // DB से data लाओ
	    }
	    
	   

//      @Override
	    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
	    	// sabse pahle dto ko category mai convert karna hai. 
			Category category = modelMapper.map(categoryDTO, Category.class);
			
			
			// fir category ko use karke database mai add krne ka logic likhna hai. 
			
			categoryRepository.save(category);
			
			// bapas se category ko DTO mai conver krke rakhna hai 
			
			CategoryDTO categoryResponseDTO  = modelMapper.map(category, CategoryDTO.class);
			
			// category DTO ko return karna hai.
			
			return categoryResponseDTO;
	    }
	    
	    
	    @Override
	    public Category getCategory(Long categoryId) {
	    	Optional<Category> category = categoryRepository.findById(categoryId);
	        return category.orElseThrow(() -> new NotFoundException("Category not found"));
	    }
	    
	    

//	    @Override
//	    public CategoryDTO updateCategory(Long categoryId, Category category) {
//	    	
////	        Category existing = getCategory(categoryId);
////	        existing.setCategoryName(category.getCategoryName());
////	        categoryRepository.save(existing); // DB में update करो
////	        return "Category updated successfully!";
//	    	
//	    	Optional<Category> existingCategory = categoryRepository.findById(categoryId);
//			
//	    	if(existingCategory.isPresent())
//	    	{
//	    		Category c = existingCategory.get();
//	    		c.setCategoryName(category.getCategoryName());
//	    		categoryRepository.save(c);
//	    		return modelMapper.map(c, CategoryDTO.class);
//	    	}else
//	    	{
//	    		throw new NotFoundException("category not found");
//	    	}
//	    
//	    }
	    
	    
//	    @Override
//	    public CategoryDTO deleteCategory(Long categoryId) {
//	    	
////	        Category existing = getCategory(categoryId);
////	        categoryRepository.delete(existing); // DB से delete करो
////	        //return "Category deleted successfully!";
////	        return category;
//	    	
//        Optional<Category> existingCategory = categoryRepository.findById(categoryId);
//	    	
//        if(existingCategory.isPresent())
//    	{
//    		Category c = existingCategory.get();
//    		categoryRepository.delete(c);
//    		return modelMapper.map(c, CategoryDTO.class);
//    	}else
//    	{
//    		throw new NotFoundException("category not found");
//    	}
//	    }
//
	    
	    

		@Override
		public CategoryDTO updateCategory(Long categoryId, CategoryDTO categoryDTO) {
			// TODO Auto-generated method stub
			return null;
		}



@Override
public CategoryDTO deleteCategory(Long categoryId) {
	// TODO Auto-generated method stub
	return null;
}

	    



//// helper Method : 
//
// private Category findByIdOrThrow(Long id)
// {
//	 Optional<Category> opt = categories.stream()
//			 .filter(c -> c.getCategoryId() != null && c.getCategoryId().equals(id))
//			 .findFirst();
//	 
//	 return opt.orElseThrow(() -> 
//	 new NotFoundException(" Category with id" + id + " not Found!"));
//	 
// }



	}