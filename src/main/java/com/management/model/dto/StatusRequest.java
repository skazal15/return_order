package com.management.model.dto;
import lombok.Data;

@Data
public class StatusRequest {
    private String statusqc;

    public StatusRequest(String statusqc){
        this.statusqc = statusqc;
    }

    // Default constructor
    public StatusRequest() {
        // Required by Jackson for deserialization
    }

    /**
     * @return String return the statusqc
     */
    public String getStatusqc() {
        return statusqc;
    }

    /**
     * @param statusqc the statusqc to set
     */
    public void setStatusqc(String statusqc) {
        this.statusqc = statusqc;
    }

}