package com.lordibe.store.abstracts;

import com.lordibe.store.abstracts.enums.PRODUCT_CATEGORY;
import com.lordibe.store.model.product.Products;
import com.lordibe.store.model.product.Stock;
import com.lordibe.store.services.service.ManagerServices;

import java.io.*;

public class Updates {

    public static void updateStockFile(String productName, int productPrice, PRODUCT_CATEGORY PRODUCTCATEGORY, int qntyOfProduct) {
        String path = "./src/main/resources/Stock.csv";
        String newPath = "./src/main/resources/temp.csv";

        File oldPath = new File(path);
        File updatedPath = new File(newPath);

        String name = productName.toLowerCase();
        String productCategory = String.valueOf(PRODUCTCATEGORY);
        String price = String.valueOf(productPrice);
        String quantity = String.valueOf(qntyOfProduct);

        if (Stock.getTotalStock().containsKey(productName)) {
            try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(newPath, true)), true))
            {
                String newQuantity = String.valueOf((Stock.getTotalStock().get(productName).getQntyOfProduct()) + qntyOfProduct);

                BufferedReader br = new BufferedReader(new FileReader(path));
                String line;

                while ((line = br.readLine()) != null) {
                    String[] list = line.split(",");

                    if (list[0].equalsIgnoreCase(name)) {
                        pw.println(name + "," + productCategory + "," + price + "," + newQuantity);
                    } else {
                        pw.println(list[0] + "," + list[1] + "," + list[2] + "," + list[3]);
                    }
                }

                br.close();
                pw.close();

                oldPath.delete();

                File dump = new File(path);

                updatedPath.renameTo(dump);

                new ManagerServices().updateStock();

                System.out.printf("%s Quantity Updated!\n", productName);
            } catch(Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, true)), true))
            {
                pw.println(name + "," + productCategory + "," + price + "," + quantity);

                System.out.println("New Stock Added!");

                new ManagerServices().updateStock();
            } catch(Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void syncStock () {
        String path = "./src/main/resources/Stock.csv";

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path)), true)) {
            pw.println("Name,Category,Price,Quantity");
            for (Products product : Stock.getTotalStock().values()) {
                String name = product.getProductName();
                String category = String.valueOf(product.getProductCategory());
                String price = String.valueOf(product.getProductPrice());
                String quantity = String.valueOf(product.getQntyOfProduct());

                pw.println(name+","+category+","+price+","+quantity);
            }
        }
        catch (Exception e) {
                System.out.println("OOPS... An Error occurred: " + e.getMessage());
        }
    }
}
