package com.lordibe.store.services.service;

import com.lordibe.store.model.customer.Customer;
import com.lordibe.store.model.product.Products;
import com.lordibe.store.model.product.Stock;
import com.lordibe.store.services.service.abstracts.Check;
import com.lordibe.store.services.service.abstracts.CustomerCart;
import com.lordibe.store.services.service.abstracts.FIFO;
import com.lordibe.store.services.service.abstracts.QuantityPriority;
import com.lordibe.store.services.serviceInterface.CustomerServiceInterface;

import java.util.HashMap;
import java.util.Map;

public class CustomerServices extends Customer implements CustomerServiceInterface {
    private Map<String, Integer> cartContent = new HashMap<>();

    CustomerCart<CustomerServices, Map<String, Integer>, Integer> cart = new CustomerCart<>(this, this.getCartContent(), this.getTotalQuantity());

    public CustomerServices(String CustomerName, String CustomerPhoneNumber) {
        super(CustomerName, CustomerPhoneNumber);
    }

    @Override
    public void viewCart() {
        System.out.println("====================");
        System.out.println("CUSTOMER'S CART");
        System.out.println("====================");
        System.out.printf("Customer : %s\n", this.getName().toUpperCase());
        System.out.println("Item    :   Quantity");
        System.out.println("--------------------");

        for (String key : cart.getCustomerCart().keySet()){
            System.out.printf("%-10s %-10s\n", key, cart.getCustomerCart().get(key));
        }

        System.out.println("===================");
    }

    @Override
    public void addToCart(String pName, int quantity) {
        String name = pName.toLowerCase();
        Map<String, Products> targetCategory = Check.checkStock(name);

        if (targetCategory != null) {
            if (targetCategory.get(name).getQntyOfProduct() <= 0) {
                System.out.printf("Sorry, %s is OUT OF STOCK!\n", name.toUpperCase());
            }
            else if ((targetCategory.get(name).getQntyOfProduct() - quantity) >= 0) {
                if (cart.getCustomerCart().containsKey(name)) {
                    cart.getCustomerCart().merge(name, quantity, Integer::sum);
                    Check.checkStock(name).get(name).setQntyOfProduct((Check.checkStock(name).get(name).getQntyOfProduct()) - (quantity));
                } else {
                    cart.getCustomerCart().put(name, quantity);
                    Check.checkStock(name).get(name).setQntyOfProduct((Check.checkStock(name).get(name).getQntyOfProduct()) - (quantity));
                }
            } else if ((targetCategory.get(name).getQntyOfProduct() - quantity) < 0) {
                if (cart.getCustomerCart().containsKey(name)) {
                    cart.getCustomerCart().merge(name, targetCategory.get(name).getQntyOfProduct(), Integer::sum);
                    Check.checkStock(name).get(name).setQntyOfProduct(0);

                } else {
                    cart.getCustomerCart().put(name, targetCategory.get(name).getQntyOfProduct());
                    Check.checkStock(name).get(name).setQntyOfProduct(0);
                }
            }
        }

        else {
            System.out.printf("OOPS... sorry, %s is unavailable in our Stock, please check for available products by viewing our stock\n", name);
        }
    }

    @Override
    public void viewStock() {
        Stock.viewTotalStock();
    }

    public Map<String, Integer> getCartContent() {
        return cartContent;
    }

    public void checkOutFIFO() {
        FIFO.setQueueCheckout(this.cart);
    }

    public void checkOutQuantityPriority() {
        QuantityPriority.setQuantityQueueCheckout(this.cart);
    }

    public int getTotalQuantity() {
        int totalQuantity = 0;
        for (int q : this.getCartContent().values()) {
            totalQuantity += q;
        }
        return totalQuantity;
    }

    public CustomerCart<CustomerServices, Map<String, Integer>, Integer> getCart() {
        return cart;
    }
}
