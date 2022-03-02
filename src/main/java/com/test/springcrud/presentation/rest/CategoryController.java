package com.test.springcrud.presentation.rest;

import com.test.springcrud.business.CategoryService;
import com.test.springcrud.business.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/api/category/{id}")
    public String getCategory(@PathVariable("id") long categoryId) {

        CategoryDto categoryDto = categoryService.getCategory(categoryId);

        return categoryDto.getCategoryId() + " " + categoryDto.getCategoryName();
    }

    @GetMapping("/api/categories")
    public List<CategoryDto> getCategories() {

        List<CategoryDto> categoryList = categoryService.getCategories();

        return categoryList;
    }
}
