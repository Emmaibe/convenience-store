package com.lordibe.store.services.service;

import com.lordibe.store.abstracts.PriorityQueueQuantity;
import com.lordibe.store.model.customer.Customer;
import com.lordibe.store.model.product.Products;
import com.lordibe.store.model.product.Stock;
import com.lordibe.store.abstracts.Check;
import com.lordibe.store.abstracts.FIFO;
import com.lordibe.store.services.serviceInterface.CustomerServiceInterface;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class CustomerServices extends Customer implements CustomerServiceInterface,Comparable<CustomerServices> {
    private Map<String, Integer> cartContent = new HashMap<>();
    private int totalQuantity = this.getTotalQuantity();


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

        for (String key : this.getCartContent().keySet()){
            System.out.printf("%-10s %-10s\n", key, this.getCartContent().get(key));
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
                if (this.getCartContent().containsKey(name)) {
                    this.getCartContent().merge(name, quantity, Integer::sum);
                    Check.checkStock(name).get(name).setQntyOfProduct((Check.checkStock(name).get(name).getQntyOfProduct()) - (quantity));
                } else {
                    this.getCartContent().put(name, quantity);
                    Check.checkStock(name).get(name).setQntyOfProduct((Check.checkStock(name).get(name).getQntyOfProduct()) - (quantity));
                }
            } else if ((targetCategory.get(name).getQntyOfProduct() - quantity) < 0) {
                if (this.getCartContent().containsKey(name)) {
                    this.getCartContent().merge(name, targetCategory.get(name).getQntyOfProduct(), Integer::sum);
                    Check.checkStock(name).get(name).setQntyOfProduct(0);

                } else {
                    this.getCartContent().put(name, targetCategory.get(name).getQntyOfProduct());
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

    public void checkOutFIFO() {
        FIFO.setQueueCheckout(this);
    }

    public void checkOutQuantityPriority() {
        PriorityQueueQuantity.setQuantityQueueCheckout(this);
    }

    public int getTotalQuantity() {
        int totalQuantity = 0;
        for (int q : this.getCartContent().values()) {
            totalQuantity += q;
        }
        return totalQuantity;
    }

    @Override
    public int compareTo(CustomerServices other) {
        return -Integer.compare(this.getTotalQuantity(), other.getTotalQuantity());
    }
}
