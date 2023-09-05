package com.lordibe.store.model.product;

import com.lordibe.store.abstracts.enums.PRODUCT_CATEGORY;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Stock {
    public Stock() {
    }

    private static Map<String, Products> totalStock = new HashMap<>();
    private static Map<String, Products> groceries = new HashMap<>();
    private static Map<String, Products> snacks = new HashMap<>();
    private static Map<String, Products> personalCare = new HashMap<>();
    private static Map<String, Products> health = new HashMap<>();
    private static Map<String, Products> alcohol = new HashMap<>();
    private static Map<String, Products> houseHoldItems = new HashMap<>();


    public void addToStock() {
        Path path = Path.of("./src/main/resources/Stock.csv");
        String line;

        try(BufferedReader reader = Files.newBufferedReader(path)) {
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");

                if (!row[0].equalsIgnoreCase("name")){
                    Products newProduct = new Products();

                    if (row[1].equalsIgnoreCase("groceries")) {
                        newProduct.setProductName(row[0]);
                        newProduct.setProductCategory(PRODUCT_CATEGORY.GROCERIES);
                        newProduct.setProductPrice(Integer.parseInt(row[2]));
                        newProduct.setQntyOfProduct(Integer.parseInt(row[3]));

                        groceries.put(row[0], newProduct);
                        totalStock.put(row[0], newProduct);
                    }

                    if (row[1].equalsIgnoreCase("snacks")) {
                        newProduct.setProductName(row[0]);
                        newProduct.setProductCategory(PRODUCT_CATEGORY.SNACKS);
                        newProduct.setProductPrice(Integer.parseInt(row[2]));
                        newProduct.setQntyOfProduct(Integer.parseInt(row[3]));

                        snacks.put(row[0], newProduct);
                        totalStock.put(row[0], newProduct);
                    }

                    if (row[1].equalsIgnoreCase("personal_Care")) {
                        newProduct.setProductName(row[0]);
                        newProduct.setProductCategory(PRODUCT_CATEGORY.PERSONAL_CARE);
                        newProduct.setProductPrice(Integer.parseInt(row[2]));
                        newProduct.setQntyOfProduct(Integer.parseInt(row[3]));

                        personalCare.put(row[0], newProduct);
                        totalStock.put(row[0], newProduct);
                    }

                    if (row[1].equalsIgnoreCase("health")) {
                        newProduct.setProductName(row[0]);
                        newProduct.setProductCategory(PRODUCT_CATEGORY.HEALTH);
                        newProduct.setProductPrice(Integer.parseInt(row[2]));
                        newProduct.setQntyOfProduct(Integer.parseInt(row[3]));

                        health.put(row[0], newProduct);
                        totalStock.put(row[0], newProduct);
                    }

                    if (row[1].equalsIgnoreCase("alcohol")) {
                        newProduct.setProductName(row[0]);
                        newProduct.setProductCategory(PRODUCT_CATEGORY.ALCOHOL);
                        newProduct.setProductPrice(Integer.parseInt(row[2]));
                        newProduct.setQntyOfProduct(Integer.parseInt(row[3]));

                        alcohol.put(row[0], newProduct);
                        totalStock.put(row[0], newProduct);
                    }

                    if (row[1].equalsIgnoreCase("household_Items")) {
                        newProduct.setProductName(row[0]);
                        newProduct.setProductCategory(PRODUCT_CATEGORY.HOUSEHOLD_ITEMS);
                        newProduct.setProductPrice(Integer.parseInt(row[2]));
                        newProduct.setQntyOfProduct(Integer.parseInt(row[3]));

                        houseHoldItems.put(row[0], newProduct);
                        totalStock.put(row[0], newProduct);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not Found: "+ e.getMessage());
        } catch (IOException e) {
            System.out.println("Input or Output Exception: "+ e.getMessage());
        }
    }

    public static Map<String, Products> getTotalStock() {
        return totalStock;
    }

    public static Map<String, Products> getGroceries() {
        return groceries;
    }

    public static Map<String, Products> getSnacks() {
        return snacks;
    }

    public static Map<String, Products> getPersonalCare() {
        return personalCare;
    }

    public static Map<String, Products> getHealth() {
        return health;
    }

    public static Map<String, Products> getAlcohol() {
        return alcohol;
    }

    public static Map<String, Products> getHouseHoldItems() {
        return houseHoldItems;
    }

    public static void setTotalSock(String name, Products product) {
        Stock.totalStock.put(name, product);
    }

    public static void setGroceries(String name, Products product) {
        Stock.groceries.put(name, product);
    }

    public static void setSnacks(String name, Products product) {
        Stock.snacks.put(name, product);
    }

    public static void setPersonalCare(String name, Products product) {
        Stock.personalCare.put(name, product);
    }

    public static void setHealth(String name, Products product) {
        Stock.health.put(name, product);
    }

    public static void setAlcohol(String name, Products product) {
        Stock.alcohol.put(name, product);
    }

    public static void setHouseHoldItems(String name, Products product) {
        Stock.houseHoldItems.put(name, product);
    }

    public static void viewSnacks() {
        System.out.println("Name           Category         Price           Quantity");
        for (Products product : snacks.values()) {
            System.out.printf("%-15s %-15s %-15s %-15s\n", product.getProductName(), product.getProductCategory(), product.getProductPrice(), product.getQntyOfProduct());
        }
    }

    public static void viewGroceries() {
        System.out.println("Name           Category         Price           Quantity");
        for (Products product : groceries.values()) {
            System.out.printf("%-15s %-15s %-15s %-15s\n", product.getProductName(), product.getProductCategory(), product.getProductPrice(), product.getQntyOfProduct());
        }
    }

    public static void viewAlcohol() {
        System.out.println("Name           Category         Price           Quantity");
        for (Products product : alcohol.values()) {
            System.out.printf("%-15s %-15s %-15s %-15s\n", product.getProductName(), product.getProductCategory(), product.getProductPrice(), product.getQntyOfProduct());
        }
    }

    public static void viewHealth() {
        System.out.println("Name           Category         Price           Quantity");
        for (Products product : health.values()) {
            System.out.printf("%-15s %-15s %-15s %-15s\n", product.getProductName(), product.getProductCategory(), product.getProductPrice(), product.getQntyOfProduct());
        }
    }

    public static void viewHouseholdItems() {
        System.out.println("Name           Category         Price           Quantity");
        for (Products product : houseHoldItems.values()) {
            System.out.printf("%-15s %-15s %-15s %-15s\n", product.getProductName(), product.getProductCategory(), product.getProductPrice(), product.getQntyOfProduct());
        }
    }

    public static void viewPersonalCare() {
        System.out.println("Name           Category         Price           Quantity");
        for (Products product : personalCare.values()) {
            System.out.printf("%-15s %-15s %-15s %-15s\n", product.getProductName(), product.getProductCategory(), product.getProductPrice(), product.getQntyOfProduct());
        }
    }

    public static void viewTotalStock() {
        System.out.println("Name           Category         Price           Quantity");
        for (Products product : totalStock.values()) {
            System.out.printf("%-15s %-15s %-15s %-15s\n", product.getProductName(), product.getProductCategory(), product.getProductPrice(), product.getQntyOfProduct());
        }
    }
}
