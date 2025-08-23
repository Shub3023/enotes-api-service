package com.becoder.service;

import java.util.List;

import com.becoder.dto.CategoryDto;
import com.becoder.dto.CategoryResponse;
import com.becoder.entity.Category;
import com.becoder.exception.ResourceNotFoundException;

public interface CategoryService {

	public Boolean saveCategory(CategoryDto categoryDto)throws Exception;
	
	public List<CategoryDto> getAllCategory();

	public List<CategoryResponse> getActiveCategory();

	public CategoryDto getCategoryById(Integer id) throws Exception;

	public Boolean deleteCategoryById(Integer id);
}
