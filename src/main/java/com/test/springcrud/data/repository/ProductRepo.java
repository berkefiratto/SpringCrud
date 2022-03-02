package com.test.springcrud.data.repository;

import com.test.springcrud.data.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
}
