package com.test.springcrud.data.entity;

//Author: berkefiratto

import javax.persistence.*;

@Entity
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    private String productName;

    private double salesPrice;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {
    }

    public Product(long productId, String productName, double salesPrice, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.salesPrice = salesPrice;
        this.category = category;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCategoryName(){
        Category category = new Category();

        String categoryName = category.getCategoryName();

        return categoryName;
    }
}
