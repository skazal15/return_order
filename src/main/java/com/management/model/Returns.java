package com.management.model;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "returns")
public class Returns implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    
    @Column(name = "orderid")
    private int orderid;

    @Column(name = "estimated_return")
    private double  estimated_return;

    @Column(name = "token")
    private String token;
    
    @Column(name = "status")
    private String status;

    @Column(name = "item_id")
    private int item_id;

    @Column(name = "quantity")
    private int quantity;

    public Returns(int orderId,double estimated_return,String token,String status,int item_id,int quantity){
        this.orderid = orderId;
        this.estimated_return = estimated_return;
        this.token = token;
        this.status = status;
        this.item_id=item_id;
        this.quantity = quantity;
    }

    // Default constructor
    public Returns() {
        // Required by JPA
    }


    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return int return the orderid
     */
    public int getOrderid() {
        return orderid;
    }

    /**
     * @param orderid the orderid to set
     */
    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    /**
     * @return double return the estimated_return
     */
    public double getEstimated_return() {
        return estimated_return;
    }

    /**
     * @param estimated_return the estimated_return to set
     */
    public void setEstimated_return(double estimated_return) {
        this.estimated_return = estimated_return;
    }

    /**
     * @return String return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return String return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return int return the item_id
     */
    public int getItem_id() {
        return item_id;
    }

    /**
     * @param item_id the item_id to set
     */
    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    /**
     * @return int return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}