/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Customer;
import java.util.Scanner;

/**
 *
 * @author st0lu
 */
public class CustomerCreator {
    public Customer returnNewCustomer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("*****************Addind new Customer******************");
        Customer customer = new Customer();
        System.out.println("Customer ID: ");
        customer.setId(scanner.nextLong());
        scanner.nextLine();
        System.out.println("Name: ");
        customer.setName(scanner.nextLine());
        System.out.println("Surname: ");
        customer.setSurname(scanner.nextLine());
        System.out.println("Money: ");
        customer.setMoney(scanner.nextInt());
        return customer;    
    }
}