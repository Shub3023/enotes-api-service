package com.becoder.utils;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.becoder.dto.CategoryDto;
import com.becoder.exception.ValidationException;

@Component
public class Validation {

	public void categoryValidation(CategoryDto categoryDto) {

		Map<String, Object> error = new LinkedHashMap<>();
		if (ObjectUtils.isEmpty(categoryDto)) {
			throw new IllegalArgumentException("category should't be null or empty");
		}
		else {
			//validation for name field
			if (ObjectUtils.isEmpty(categoryDto.getName())) {
				error.put("name", "name shouldn't empty or null");
			} else {
				if (categoryDto.getName().length() < 10) {
					error.put("name", "name length less than 10");
				}
				if (categoryDto.getName().length() > 100) {
					error.put("name", "name length more than 100");
				}
			}
			//validation for description field
			if(ObjectUtils.isEmpty(categoryDto.getDescription())){
				error.put("description", "description shouldn't empty or null");
			}
			
			//validation for isActive field
			if(categoryDto.getIsActive() != Boolean.TRUE && categoryDto.getIsActive() != Boolean.FALSE) {
				error.put("isActive", "isActive true or false");
			}
		}
		if(!error.isEmpty()) {
			throw new ValidationException(error);
		}
	}

}
