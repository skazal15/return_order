package com.management.model.dto;
import lombok.Data;

@Data
public class ResponseReturn {
    private String orderId;
    private double estimated_return;
    private String token;
    private String status;
    private String item;
    private int quantity;
    private String qc;
    private double price;

    public ResponseReturn(String orderId,double estimated_return,String token,
                        String status,String item,int quantity,String qc,double price){
                            this.orderId=orderId;
                            this.estimated_return=estimated_return;
                            this.token=token;
                            this.status=status;
                            this.item=item;
                            this.quantity=quantity;
                            this.qc=qc;
                            this.price=price;
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
     * @return String return the item
     */
    public String getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(String item) {
        this.item = item;
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
     * @return String return the qc
     */
    public String getQc() {
        return qc;
    }

    /**
     * @param qc the qc to set
     */
    public void setQc(String qc) {
        this.qc = qc;
    }

    /**
     * @return double return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

}