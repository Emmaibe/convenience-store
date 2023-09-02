package com.lordibe.store.services.serviceInterface;

public interface CustomerServiceInterface {
    void viewCart();

    void addToCart(String name, int qnty);

    void viewStock();
}
