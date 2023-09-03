package com.lordibe.store.services.service.abstracts;

import com.lordibe.store.services.service.CustomerServices;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerCart <T, K, I> {
    T cutomer;
    K customerCart;
    I productQuantity;

    public CustomerCart(T cutomer, K customerCart, I productQuantity) {
        this.cutomer = cutomer;
        this.customerCart = customerCart;
        this.productQuantity = productQuantity;
    }
}
