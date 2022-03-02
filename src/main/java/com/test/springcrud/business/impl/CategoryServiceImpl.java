package com.test.springcrud.business.impl;

import com.test.springcrud.business.CategoryService;
import com.test.springcrud.business.dto.CategoryDto;
import com.test.springcrud.data.entity.Category;
import com.test.springcrud.data.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public CategoryDto getCategory(long categoryId) {

        Optional<Category> optional = categoryRepo.findById(categoryId);

        if (optional.isPresent()) {
            CategoryDto categoryDto = toDto(optional.get());
            return categoryDto;
        }

        return null;
    }

    @Override
    public List<CategoryDto> getCategories() {

        List<CategoryDto> categoryDtos = new ArrayList<>();

        for (Category category : categoryRepo.findAll()) {
            categoryDtos.add(toDto(category));
        }
        return categoryDtos;
    }

    public CategoryDto toDto(Category category) {

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setCategoryId(category.getCategoryId());
        categoryDto.setCategoryName(category.getCategoryName());

        return categoryDto;
    }

    public Category toEntity(CategoryDto categoryDto) {

        Category category = new Category();

        category.setCategoryId(categoryDto.getCategoryId());
        category.setCategoryName(categoryDto.getCategoryName());

        return category;
    }


}
