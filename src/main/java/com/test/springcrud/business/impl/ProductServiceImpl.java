package com.test.springcrud.business.impl;

import com.test.springcrud.business.ProductService;
import com.test.springcrud.business.dto.CategoryDto;
import com.test.springcrud.business.dto.ProductDto;
import com.test.springcrud.data.entity.Category;
import com.test.springcrud.data.entity.Product;
import com.test.springcrud.data.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @Override
    public ProductDto getProduct(long productId) {

        Optional<Product> optional = productRepo.findById(productId);

        if (optional.isPresent()) {

            ProductDto productDto = toProdDto(optional.get());

            return productDto;
        }

        return null;
    }

    @Override
    public List<ProductDto> getProducts() {

        List<ProductDto> productDtoList = new ArrayList<>();

        for(Product product : productRepo.findAll()) {

            product.getProductId();
            product.getProductName();
            product.getSalesPrice();
            product.getCategory();

            productDtoList.add(toProdDto(product));

        }

        return productDtoList;
    }

    public ProductDto toProdDto(Product product) {

        ProductDto productDto = new ProductDto();

        productDto.setProductId(product.getProductId());
        productDto.setProductName(product.getProductName());
        productDto.setSalesPrice(product.getSalesPrice());

        Category category = product.getCategory();
        CategoryDto categoryDto = categoryServiceImpl.toDto(category);

        productDto.setCategoryDto(categoryDto);

        return productDto;
    }

    public Product toEntity(ProductDto productDto) {

        Product product = new Product();

        product.setProductId(productDto.getProductId());
        product.setProductName(productDto.getProductName());
        product.setSalesPrice(productDto.getSalesPrice());


        return product;
    }

}
