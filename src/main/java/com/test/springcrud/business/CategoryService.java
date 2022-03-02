package com.test.springcrud.business;

import com.test.springcrud.business.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto getCategory(long categoryId);

    List<CategoryDto> getCategories();


}
