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
            System.out.println(i + 1 + ". " + products.get(i).getName() + " || Cost: " + products.get(i).getPrice()
                    + " || Quantity at the shop: " + products.get(i).getCount());
        }
        System.out.println("list of Customers: ");
        int countCustomers = customers.size();
        for (int i = 0; i < countCustomers; i++) {
            System.out.println(i + 1 + ". " + customers.get(i).getName()
                    + " " + customers.get(i).getSurname()
                    + " || Available money: " + customers.get(i).getMoney());

        }
        System.out.println("Choose a product, by its number: ");
        System.out.println("(0 ot EXIT)");
        int numberProduct = scanner.nextInt();
        if(numberProduct < 1) return null;
        Product product = products.get(numberProduct - 1);
        System.out.println("Choose a customer, by its number: ");
        System.out.println("(-1 to EXIT)");
        int numberCustomer = scanner.nextInt();
        if(numberCustomer < 0) return null;
        Customer customer = customers.get(numberCustomer - 1);
        System.out.println("Choose quantity: ");
        int quantity = scanner.nextInt();
        Calendar c = new GregorianCalendar();
        Purchase purchase = new Purchase(null, product, customer,null, c.getTime(), quantity);
        return purchase;
        //  ------------------------

    }
}
