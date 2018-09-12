/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jktvr17shop;

import classes.CustomerCreator;
import classes.ProductCreator;
import classes.ProductReturner;
import classes.PurchaseCreator;
import classes.PurchaseReturner;
import entity.Customer;
import entity.Product;
import entity.Purchase;
import interfaces.Manageable;
import java.util.List;

/**
 *
 * @author st0lu
 */
public class ConsoleInterface implements Manageable {

    @Override
    public Product createProduct() {
        ProductCreator productCreator = new ProductCreator();
        return productCreator.returnNewProduct();
    }

    @Override
    public Customer createCustomer() {
        CustomerCreator customerCreator = new CustomerCreator();
        return customerCreator.returnNewCustomer();
    }

    @Override
    public Purchase issueProduct(List<Product> products, List<Customer> customers) {
        PurchaseCreator purchaseCreator = new PurchaseCreator();
        return purchaseCreator.returnNewPurchase(products, customers);
    }

    @Override
    public boolean returnProduct(List<Purchase> purchases) {
        ProductReturner productReturner = new ProductReturner();
        return productReturner.returnPurchase(purchases);
    }

    @Override
    public void returnPurchase(List<Purchase> purchases) {
        PurchaseReturner purchaseReturner = new PurchaseReturner();
        purchaseReturner.printListWhoBoughtProducts(purchases);
    }

}
