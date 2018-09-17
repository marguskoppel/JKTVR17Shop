/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Purchase;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author st0lu
 */
public class ProductReturner {

    public Purchase returnPurchase(List<Purchase> purchases) {
        
            System.out.println("*************Product returning*************");
            Purchase purchase = new Purchase();
            Scanner scanner = new Scanner(System.in);
            int countPurchases = purchases.size();
            for (int i = 0; i < countPurchases; i++) {
                Purchase purch = purchases.get(i);
                System.out.println(i + 1 + ". " + purch.getCustomer().getName()
                        + " " + purch.getCustomer().getSurname()
                        + " " + purch.getProduct().getName());

            }
            System.out.println("Choose which product you want to return: ");
            System.out.println("To not to do anything press -1");
            int numPurchase = scanner.nextInt();
            if (numPurchase < 0) {
                return null;
            }
            purchase = purchases.get(numPurchase - 1);
            purchases.remove(purchase);
            Calendar c = new GregorianCalendar();
            purchase.setProductReturn(c.getTime());
            return purchase;

         
    }
}
