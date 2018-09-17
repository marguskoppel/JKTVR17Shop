/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jktvr17shop;

import entity.Customer;
import entity.Product;
import entity.Purchase;
import interfaces.Retentive;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author pupil
 */
public class PersistToDatabase implements Retentive {

    private final EntityManager em;
    private final EntityTransaction tx;

    public PersistToDatabase() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JKTVR17ShopPU");
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }
    @Override
    public void freeResources() {
        if (em != null) {
            em.close();
        }
    }
    @Override
    public void saveProduct(Product product) {
        tx.begin();
        em.persist(product);
        tx.commit();
    }

    @Override
    public void saveCustomer(Customer customer) {
        tx.begin();
        em.persist(customer);
        tx.commit();
    }

    @Override
    public void savePurchase(Purchase purchase, boolean update) {
        tx.begin();
        if (update) {
            em.merge(purchase);
        } else {
            em.persist(purchase);
        }
        tx.commit();
    }

    @Override
    public List<Product> loadProducts() {
        try{
            return em.createQuery("SELECT p FROM Product p").getResultList();
        }catch(Exception e){
            return new ArrayList<Product>();
        }
    }

    @Override
    public List<Customer> loadCustomers() {
        try{
            return em.createQuery("SELECT c FROM Customer c").getResultList();
        }catch(Exception e){
            return new ArrayList<Customer>();
        }
    }

    @Override
    public List<Purchase> loadPurchases() {
        try{
            return em.createQuery("SELECT ph FROM Purchase ph").getResultList();
        }catch(Exception e){
            return new ArrayList<Purchase>();
        }
    }

    
}
