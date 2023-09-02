package com.lordibe.store;

import com.lordibe.store.model.product.Stock;
import com.lordibe.store.model.staff.Cashier;
import com.lordibe.store.model.staff.Manager;
import com.lordibe.store.services.service.abstracts.enums.PRODUCT_CATEGORY;
import com.lordibe.store.services.service.abstracts.enums.STAFF_TYPE;
import com.lordibe.store.services.service.CashierServices;
import com.lordibe.store.services.service.CustomerServices;
import com.lordibe.store.services.service.ManagerServices;

public class Main {
    public static void main(String[] args) {

        //NEW CHANGES MADE IN WEEK 2.

        //Stock object
        Stock stock = new Stock();

        //Manager object.
        Manager manager = new Manager("Ibe", 35, "08062331156", "eliteibe69@gmail.com", "MSc", 200_000, STAFF_TYPE.MANAGER);

        //Manager Service object.
        ManagerServices managerServices = new ManagerServices();

        //Cashier Objects.
        Cashier cashier1 = new Cashier("Emmanuel", 25, "08038579630", "ik@gmail.com", "BSc", 100_000, STAFF_TYPE.CASHIER);
        Cashier cashier2 = new Cashier("Voke", 28, "08064656306", "voke@gmail.com", "School Cert", 100_000, STAFF_TYPE.CASHIER);

        //Cashier Service object.
        CashierServices cashierService = new CashierServices();

        //Customer Service object.
        CustomerServices customer1 = new CustomerServices("Pelumi", "08094577448");
        CustomerServices customer2 = new CustomerServices("Ikechukwu", "09044335746");



        //IMPLEMENTING VARIOUS METHODS

        //Manager Services
        managerServices.updateStock(); /*Reads from the Stock.csv file which hold all products in the store,
                                        sorts them and stores them in different maps with respect to their
                                        category (Located in the Stock class)*/

        System.out.println();

        managerServices.checkStock(); /*Loops through and prints out the total stock from the "totalStock"
                                        Map (located in the Stock class) after the maps have been updated
                                        by the managerService object*/

        System.out.println();


        //STOCK
        Stock.viewGroceries(); //Viewing various stock categories after manager updates the stock.
        System.out.println();
        Stock.viewHouseholdItems();
        System.out.println();
        Stock.viewSnacks();

        System.out.println();

        managerServices.addToStock("GoldenMorn", 1000, PRODUCT_CATEGORY.GROCERIES,5);
        managerServices.addToStock("GoldenMorn", 1000, PRODUCT_CATEGORY.GROCERIES,5);
        managerServices.addToStock("TorchLight", 1500, PRODUCT_CATEGORY.HOUSEHOLD_ITEMS,15);
        managerServices.addToStock("Surge", 2500, PRODUCT_CATEGORY.HOUSEHOLD_ITEMS,50);
        managerServices.addToStock("Pringles", 5500, PRODUCT_CATEGORY.SNACKS,50);

                                      /*Appends or Updates the quantity of the Stock.csv file by calling a method
                                      called "updateStockFile()" in the Updates class, which reads through the contents
                                      of the Stock.csv file while checking if the new product being adding by the manager
                                      already exist. if it does, it updates the quantity of the given product. if it does
                                      not, it appends the new product to the Stock.csv file and for any of the two cases
                                      automatically updates the current stock maps by calling the "updateStock()" method*/

        System.out.println();


        //Customer services
        customer1.addToCart("Bread", 10); /*Adds product to the customer cart. it calls a checkStock(pName)
                                                           method (Check class) which sorts and returns a category map
                                                           which contains the specified product. The add to cart method
                                                           goes through the map and compares the current product quantity
                                                           with the specified quantity the customer needs. If the difference
                                                           is greater than 0, it adds the product to the map or merges the
                                                           quantity if they already exists in the cart. If the difference
                                                           is less than 0, it adds the product with the remaining quantity
                                                           in the stock (nothing more) or merges the remaining quantity with
                                                           the quantity belonging to the specified product if already in the map.
                                                           It prints out the "OUT OF STOCK" and add nothing to the cart if the
                                                           quantity is zero. After performing the above functions, it automatically
                                                           removes the quantity for each product added to the customer's cart
                                                           form the category map.*/

        customer1.addToCart("Bread", 10);
        customer1.addToCart("bread", 10);   //Adding more bread to confirm increase in bread's quantity in the cart.
//        customer1.addToCart("Bread", 10);
//        customer1.addToCart("Bread", 10);
//        customer1.addToCart("Bread", 10);
//        customer1.addToCart("Bread", 10);
//        customer1.addToCart("Bread", 10);
//        customer1.addToCart("Bread", 10);
//        customer1.addToCart("Bread", 11);                 //Trying to exhaust the Bread product from the list to confirm "OUT OF STOCK".
        customer1.addToCart("Surge", 11);
        customer1.addToCart("pringles", 11);
        customer1.addToCart("torchLight", 11);
        customer1.addToCart("GoldenMorn", 11);
        customer1.addToCart("sanitizers", 11);
        customer1.addToCart("Tea", 11);
        customer1.addToCart("vodka", 11);


        System.out.println();


        customer1.viewCart(); //Customer viewing her cart.

        System.out.println();

        customer2.addToCart("Tea", 5); //Customer2 adding to his cart.
        customer2.addToCart("Pringles", 10);
        customer2.addToCart("Gin", 5);

        customer2.viewCart(); //Customer2 viewing his cart.

        System.out.println();

        //Cashier Service
        cashierService.issuesReceipt(customer1, cashier1); /*Issuing a receipt to a customer. It loops through the customer's
                                                            cart, issues a detailed receipt and automatically synchronizes
                                                            and effects the current changes in the category Stock Map due to
                                                            the customer's purchase, with the Stock.csv file. It does this by
                                                            calling the (syncStock()) method founf in the "Updates class". */
        System.out.println();


        cashierService.issuesReceipt(customer2, cashier2); //Issuing a receipt to customer2.
    }
}