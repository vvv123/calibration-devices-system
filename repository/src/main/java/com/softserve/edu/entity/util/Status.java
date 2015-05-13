package com.softserve.edu.entity.util;

public enum Status {
    SENT("Надіслана"), RECEIVED("Отримана"), IN_PROGRESS("В процесі обробки"), COMPLETED("Завершена"),
    NOT_FOUND("Заявку з таким кодом не знайдено");

    private String name;

    private Status(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
