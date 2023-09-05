package com.lordibe.store.abstracts;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerCart <T, K, Q> {
    T CUSTOMER;
    K CUSTOMER_CART;
    Q PRODUCT_QUANTITY;

    public CustomerCart(T customer, K customerCart, Q productQuantity) {
        this.CUSTOMER = customer;
        this.CUSTOMER_CART = customerCart;
        this.PRODUCT_QUANTITY = productQuantity;
    }
}
