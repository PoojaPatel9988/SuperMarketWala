package com.example.seventh_project_super_market_wala.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="CATEGORY")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;
	private String categoryName;
	public Long getCategoryId() {
		return categoryId;
	}
	
	
//	public Category() {
//	
//	}
//
//
//	public Category(Long categoryId, String categoryName) {
//		super();
//		this.categoryId = categoryId;
//		this.categoryName = categoryName;
//	}
//
//
//	public String getCategoryName() {
//		return categoryName;
//	}
//	public void setCategoryName(String categoryName) {
//		this.categoryName = categoryName;
//	}
//	public void setCategoryId(Long categoryId) {
//		this.categoryId = categoryId;
//	}
//	@Override
//	public String toString() {
//		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
//	}
//	

}
