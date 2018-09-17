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
import interfaces.Retentive;
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
    private Retentive saver = new PersistToDatabase();
    
    public App() {
        this.products = saver.loadProducts();
        this.customers = saver.loadCustomers();
        this.purchases = saver.loadPurchases();
    }
    
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
                    
                    Product product = manager.createProduct();
                    if (product != null) {
                        
                        products.add(product);
                        saver.saveProduct(product);
                    }
                    break;
                case 2:
                    
                    Customer customer = manager.createCustomer();
                    if (customer != null) {
                        
                        customers.add(customer);
                        saver.saveCustomer(customer);
                    }
                    break;
                case 3:
                    
                    Purchase purchase = manager.issueProduct(products, customers);
                    if (purchase != null) {
                        purchases.add(purchase);
                        saver.savePurchase(purchase, false);                        
                    }
                    break;
                case 4:
                    Purchase pc = manager.returnProduct(purchases);
                    if (pc != null) {
                        saver.savePurchase(pc, true);
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
