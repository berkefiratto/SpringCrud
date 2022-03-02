package com.test.springcrud.business;

import com.test.springcrud.business.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto getProduct(long productId);

    List<ProductDto> getProducts();

}
