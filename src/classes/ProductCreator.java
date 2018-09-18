/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Product;
import java.util.Scanner;

/**
 *
 * @author st0lu
 */
public class ProductCreator {

    public Product returnNewProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("****************Adding new Product*******************");
        Product product = new Product();
        System.out.println("Product ID: ");
        product.setId(scanner.nextLong());
        scanner.nextLine();
        System.out.println("Product Name: ");
        product.setName(scanner.nextLine());
        System.out.println("Product Price: ");
        product.setPrice(scanner.nextInt());
        System.out.println("Product Count: ");
        product.setCount(scanner.nextInt());
        System.out.println("To ADD push A\n For Cancel press -1");
        String add = "a";
        String yes = "";
        yes = scanner.next();
        if(!add.equals(yes)){
            System.out.println("***** Product IS NOT added *****");
            return null;
        }else{
            System.out.println("***** Product IS added *****");
        return product;
    }
}
}