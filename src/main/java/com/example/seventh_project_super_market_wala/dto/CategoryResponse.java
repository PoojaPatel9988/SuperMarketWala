package com.example.seventh_project_super_market_wala.dto;

import java.util.List;

public class CategoryResponse {
	
	private List<CategoryDTO> content;
	private Long totalElement;
	private int totalPages;
	private int size;
	private int number;
	private int totalNumberOfElements;
	private boolean islastPage;

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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getTotalNumberOfElements() {
		return totalNumberOfElements;
	}

	public void setTotalNumberOfElements(int totalNumberOfElements) {
		this.totalNumberOfElements = totalNumberOfElements;
	}

	public boolean isIslastPage() {
		return islastPage;
	}

	public void setIslastPage(boolean islastPage) {
		this.islastPage = islastPage;
	}

	

//	@Override
//	public String toString() {
//		return "ResponseDTO [content=" + content + ", totalElement=" + totalElement + ", totalPages=" + totalPages
//				+ "]";
//	}

	
	
	

}
