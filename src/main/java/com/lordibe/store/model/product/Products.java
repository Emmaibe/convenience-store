package com.lordibe.store.model.product;

import com.lordibe.store.abstracts.enums.PRODUCT_CATEGORY;

import java.util.Objects;

public class Products {
    private String productName;
    private int productPrice;
    private PRODUCT_CATEGORY PRODUCTCATEGORY;

    private int qntyOfProduct;


    public Products(String productName, int productPrice, PRODUCT_CATEGORY PRODUCTCATEGORY, int qntyOfProduct) {
        this.productName = productName.toLowerCase();
        this.productPrice = productPrice;
        this.PRODUCTCATEGORY = PRODUCTCATEGORY;
        this.qntyOfProduct = qntyOfProduct;
    }

    public Products() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public PRODUCT_CATEGORY getProductCategory() {
        return PRODUCTCATEGORY;
    }

    public void setProductCategory(PRODUCT_CATEGORY PRODUCTCATEGORY) {
        this.PRODUCTCATEGORY = PRODUCTCATEGORY;
    }

    public int getQntyOfProduct() {
        return qntyOfProduct;
    }

    public void setQntyOfProduct(int qntyOfProduct) {
        this.qntyOfProduct = qntyOfProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Products products)) return false;
        return getProductPrice() == products.getProductPrice() && Objects.equals(getProductName(), products.getProductName()) && getProductCategory() == products.getProductCategory();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductName(), getProductPrice(), getProductCategory());
    }
}
