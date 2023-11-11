package com.management.model.dto;

import lombok.Data;

@Data
public class ReturnDTO {
    
    private String orderId;
    private String email;
    private int quantity;
    private int itemId;

    public ReturnDTO(String orderId, String email, int quantity,int itemId){
        super();
        this.orderId = orderId;
        this.email = email;
        this.quantity = quantity;
        this.itemId = itemId;
    }


    /**
     * @return String return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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

    /**
     * @return int return the itemId
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

}