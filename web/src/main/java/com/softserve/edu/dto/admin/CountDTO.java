package com.softserve.edu.dto.admin;

public class CountDTO {
    private Long count;

    public CountDTO() {
    }

    public CountDTO(Long count) {
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
