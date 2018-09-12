/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jktvr17shop;

import classes.CustomerCreator;
import classes.ProductCreator;
import classes.PurchaseCreator;
import entity.Customer;
import entity.Product;
import entity.Purchase;
import interfaces.Manageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author st0lu
 */
public class App {

    private List<Product> products = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Purchase> purchases = new ArrayList<>();
    private Manageable manager = new ConsoleInterface();

    public void run() {
        String repeat = "r";
        Scanner scanner = new Scanner(System.in);
        int task;
        do {
            System.out.println("***************WELCOME TO THE SHOP!****************");
            System.out.println("Choose your action:");
            System.out.println("0 - EXIT");
            System.out.println("1 - ADD PRODUCT");
            System.out.println("2 - ADD CUSTOMER");
            System.out.println("3 - to BUY");
            System.out.println("4 - to RETURN");
            System.out.println("5 - Purchases history");

            task = scanner.nextInt();
            switch (task) {
                case 0:
                    repeat = "s";
                    break;
                case 1:

                    products.add(manager.createProduct());
                    break;
                case 2:

                    customers.add(manager.createCustomer());
                    break;
                case 3:

                    purchases.add(manager.issueProduct(products, customers));
                    break;
                case 4:
                    if (manager.returnProduct(purchases)) {
                        System.out.println("Product returned");
                    } else {
                        System.out.println("Could not return the product");
                    }
                    break;
                case 5:
                    manager.returnPurchase(purchases);
                    break;
                default:
                    System.out.println("Choose ONE of the actions!");

            }

        } while ("r".equals(repeat));

    }

}
