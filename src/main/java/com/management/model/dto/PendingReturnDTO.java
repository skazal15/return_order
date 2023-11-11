package com.management.model.dto;
import lombok.Data;

@Data
public class PendingReturnDTO {
    private String orderId;
    private String email;

    public PendingReturnDTO(String orderId,String email){
        super();
        this.orderId = orderId;
        this.email = email;
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

}