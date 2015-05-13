package com.softserve.edu.entity.util;

public enum Status {
    SENT("Відправлено"), RECEIVED("Отримано"), IN_PROGRESS("В процесі обробки"), COMPLETED("Завершена"),
    NOT_FOUND("Заявки з таким кодом не існує");

    private String name;

    private Status(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
