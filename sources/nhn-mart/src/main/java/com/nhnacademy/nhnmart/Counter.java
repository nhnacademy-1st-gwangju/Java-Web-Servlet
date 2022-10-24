package com.nhnacademy.nhnmart;

import java.util.ArrayList;

public class Counter {


    public void count(ArrayList<Food> foods, int money) {
        int totalPrice = 0;
        for (Food food : foods) {
            totalPrice += food.getPrice();
        }

        if (money < totalPrice) {
            throw new IllegalArgumentException("금액이 부족합니다. 보유 금액: 20,000원, 총 가격: " + totalPrice);
        } else {
            System.out.println("고객님 결제 후 잔액: " + (money - totalPrice));
        }
    }
}
