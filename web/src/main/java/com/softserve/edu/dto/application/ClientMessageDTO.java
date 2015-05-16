package com.softserve.edu.dto.application;

public class ClientMessageDTO {
    private String status;

    public ClientMessageDTO(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
