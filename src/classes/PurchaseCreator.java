/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Customer;
import entity.Product;
import entity.Purchase;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author st0lu
 */
public class PurchaseCreator {
    public Purchase returnNewPurchase(List<Product> products, List<Customer> customers) {
        System.out.println("******************Selling product(s) to customer(s)********************");
        Scanner scanner = new Scanner(System.in);
        System.out.println("List of Products: ");
        int countProducts = products.size();
        for (int i = 0; i < countProducts; i++) {
            System.out.println(i + 1 + ". " + products.get(i).getName() + " " + products.get(i).getPrice()
                    + " " + products.get(i).getCount());
        }
        System.out.println("list of Customers: ");
        int countCustomers = customers.size();
        for (int i = 0; i < countCustomers; i++) {
            System.out.println(i + 1 + ". " + customers.get(i).getName()
                    + " " + customers.get(i).getSurname()
                    + " " + customers.get(i).getMoney());

        }
        System.out.println("Choose a product, by its number: ");
        int numberProducts = scanner.nextInt();
        Product product = products.get(numberProducts - 1);
        System.out.println("Choose a customer, by its number: ");
        int numberCustomer = scanner.nextInt();
        Customer customer = customers.get(numberCustomer - 1);
        System.out.println("Choose quantity: ");
        int quantity = scanner.nextInt();
        Calendar c = new GregorianCalendar();
        Purchase purchase = new Purchase(null, product, customer,null, c.getTime(), quantity);
        return purchase;
        //  ------------------------

    }
}
