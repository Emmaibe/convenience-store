package com.lordibe.store.services.serviceInterface;

public interface CustomerServiceInterface {
    void viewCart();

    String addToCart(String name, int qnty);

    void viewStock();
}
