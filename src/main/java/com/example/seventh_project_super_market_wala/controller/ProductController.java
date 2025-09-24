package com.example.seventh_project_super_market_wala.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.seventh_project_super_market_wala.model.Product;
@RestController
@RequestMapping("/api")
public class ProductController {
	
	List<Product> productes =new ArrayList<>();
	
	@GetMapping("/productes/g")
	List<Product>getpro()
	{
		return productes;
	}
	
	@PostMapping("/productes/p")
	String addProduct(@RequestBody Product product)
	{
		productes.add(product);
		return "product added successfukky!";
	}
	
	@DeleteMapping("/productes/d/{proId}")
	String removeProduct( @PathVariable("proId") int productId)
	{
		productId = productId-1;
		productes.remove(productId);
		return "product delete successfuly!";
	}
	
	@PutMapping("/productes/u/{produId}")
    String updateProduct( @PathVariable("produId") int productId,@RequestBody Product product)
    {
		productId = productId - 1;
        productes.set(productId, product);
        return "product update successfully!";
    }
	
}


//get=http://localhost:8080/api/productes/g
//post=http://localhost:8080/api/productes/p
//json code:
//{
//	  "id": 1,
//	  "name": "Apple",
//	  "price": 50.0
//	}
//delete=http://localhost:8080/api/productes/d/1
//put= http://localhost:8080/api/productes/u/1
//{
//	  "id": 1,
//	  "name": "Banana",
//	  "price": 30.0
//	}
