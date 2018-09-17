/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.Customer;
import entity.Product;
import entity.Purchase;
import java.util.List;

/**
 *
 * @author st0lu
 */
public interface Manageable {
    public Product createProduct();
    public Customer createCustomer();
    public Purchase issueProduct(List<Product> products, List<Customer> customers);
    public Purchase returnProduct(List<Purchase> purchases);
    public void returnPurchase(List<Purchase> purchases);
}
