package com.test.springcrud.data.repository;

import com.test.springcrud.data.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {
}
