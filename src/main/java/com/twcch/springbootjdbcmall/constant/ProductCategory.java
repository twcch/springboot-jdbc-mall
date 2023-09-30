package com.twcch.springbootjdbcmall.constant;

public enum ProductCategory {

    FOOD(1), BOOK(2), E_BOOK(3), CAR(4);

    private int number;

    private ProductCategory(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
