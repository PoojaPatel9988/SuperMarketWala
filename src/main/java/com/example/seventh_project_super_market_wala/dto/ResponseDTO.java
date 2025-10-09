package com.example.seventh_project_super_market_wala.dto;

import java.util.List;

public class ResponseDTO {
	
	private List<CategoryDTO> content;

	public List<CategoryDTO> getContent() {
		return content;
	}

	public void setContent(List<CategoryDTO> content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ResponseDTO [content=" + content + "]";
	}
	
	

}
