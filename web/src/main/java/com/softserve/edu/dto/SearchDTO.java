package com.softserve.edu.dto;

public class SearchDTO {
    private String data;

    public SearchDTO(String data) {
        this.data = data;
    }

    public SearchDTO() {}

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
