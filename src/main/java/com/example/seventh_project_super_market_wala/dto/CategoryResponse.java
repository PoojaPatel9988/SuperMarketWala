package com.example.seventh_project_super_market_wala.dto;

import java.util.List;

public class CategoryResponse {
	
	private List<CategoryDTO> content;
	private Long totalElement;
	private int totalPages;

	public Long getTotalElement() {
		return totalElement;
	}

	public void setTotalElement(Long totalElement) {
		this.totalElement = totalElement;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<CategoryDTO> getContent() {
		return content;
	}

	public void setContent(List<CategoryDTO> content) {
		this.content = content;
	}

//	@Override
//	public String toString() {
//		return "ResponseDTO [content=" + content + ", totalElement=" + totalElement + ", totalPages=" + totalPages
//				+ "]";
//	}

	
	
	

}
