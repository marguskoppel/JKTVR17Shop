/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Purchase;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author st0lu
 */
public class PurchaseReturner {

    public void printListWhoBoughtProducts(List<Purchase> purchases) {
        System.out.println("*********************List of customers who bought products*****************");
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int countPurchases = purchases.size();
        for (int i = 0; i < countPurchases; i++) {
            Purchase p = purchases.get(i);
            if (p.getProductReturn() == null) {
                System.out.println(i + 1 + ". "+p.getQuantity()+" " + p.getProduct().getName() + ". Bought by: " + p.getCustomer().getName() + " " + p.getCustomer().getSurname() + ". Date: " + sdfDate.format(p.getProductIssued())
            
        
    

);
            
            }

            }
            
        }
}
