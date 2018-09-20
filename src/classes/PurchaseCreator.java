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
        if (numberProduct < 1) {
            return null;
        }
        Product product = products.get(numberProduct - 1);
        System.out.println("Choose a customer, by its number: ");
        System.out.println("(-1 to EXIT)");
        int numberCustomer = scanner.nextInt();
        if (numberCustomer < 0) {
            return null;
        }
        Customer customer = customers.get(numberCustomer - 1);
        System.out.println("Choose quantity: ");
        int quantity = scanner.nextInt();
        if (product.getCount() - quantity < 0) { //product quantity check
            System.out.println("There is not enough product in the shop");
            return null;

        }
        if (product.getPrice() * quantity > customer.getMoney()) {//money check
            System.out.println("Customer doesnt have enough money");
            return null;

        }
        if (customer.getMoney() <= 0) { //customer money check
            System.out.println("Customer doesnt have any money");
            return null;
        }
        if (product.getCount() <= 0) {//product count check
            System.out.println("Ther is no more of this product at the shop");
            return null;

        }

        Calendar c = new GregorianCalendar();
        Purchase purchase = new Purchase(null, product, customer, null, c.getTime(), quantity);
        purchase.getCustomer().setMoney(purchase.getCustomer().getMoney() - purchase.getProduct().getPrice() * purchase.getQuantity());
        purchase.getProduct().setCount(purchase.getProduct().getCount() - purchase.getQuantity());
        System.out.println("==========PURCHASE WAS SUCCESSFUL==========\n");
        System.out.println("***************" + customer.getName() + " " + customer.getSurname() + " bought " + purchase.getQuantity() + " " + product.getName() + "**************\n");

        return purchase;

    }

}
