/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author st0lu
 */
@Entity
public class Purchase {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@OneToOne
    private Product product;
@OneToOne
    private Customer customer;
@Temporal(TemporalType.TIMESTAMP)
    private Date productReturn;
@Temporal(TemporalType.TIMESTAMP)
    private Date productIssued;
    private Integer quantity;

    public Purchase() {
    }

    public Purchase(Long id, Product product, Customer customer, Date productReturn, Date productIssued, Integer quantity) {
        this.id = id;
        this.product = product;
        this.customer = customer;
        this.productReturn = productReturn;
        this.productIssued = productIssued;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getProductReturn() {
        return productReturn;
    }

    
    public void setProductReturn(Date productReturn) {
        this.productReturn = productReturn;
    }

    public Date getProductIssued() {
        return productIssued;
    }

    public void setProductIssued(Date productIssued) {
        this.productIssued = productIssued;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.product);
        hash = 53 * hash + Objects.hashCode(this.customer);
        hash = 53 * hash + Objects.hashCode(this.productReturn);
        hash = 53 * hash + Objects.hashCode(this.productIssued);
        hash = 53 * hash + Objects.hashCode(this.quantity);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Purchase other = (Purchase) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        if (!Objects.equals(this.productReturn, other.productReturn)) {
            return false;
        }
        if (!Objects.equals(this.productIssued, other.productIssued)) {
            return false;
        }
        if (!Objects.equals(this.quantity, other.quantity)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Purchase{" + "id=" + id + ", product=" + product.getName() + ", customer=" + customer.getName() + " " + customer.getSurname() + ", productReturn=" + productReturn + ", productIssued=" + productIssued + ", quantity=" + quantity + '}';
    }

}
