package com.softserve.edu.dto;

import java.util.List;

public class PageDTO<T> {

    private Long totalItems;
    private List<T> content;

    public PageDTO() {}

    public PageDTO(Long totalItems, List<T> content) {
        this.totalItems = totalItems;
        this.content = content;
    }

    public Long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Long totalItems) {
        this.totalItems = totalItems;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}
