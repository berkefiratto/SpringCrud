package com.test.springcrud.presentation.rest;

import com.test.springcrud.business.ProductService;
import com.test.springcrud.business.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/api/product/{id}")
    public String productView(@PathVariable("id") long productId) {

        ProductDto productDto = productService.getProduct(productId);

        return productDto.getProductId() + " " +
                productDto.getProductName() + " " +
                productDto.getSalesPrice() + " " +
                productDto.getCategoryDto().getCategoryName();
    }

    @GetMapping("/api/products")
    public List<ProductDto> getProducts() {

        List<ProductDto> productDtoList = productService.getProducts();

        return productDtoList;
    }
}
