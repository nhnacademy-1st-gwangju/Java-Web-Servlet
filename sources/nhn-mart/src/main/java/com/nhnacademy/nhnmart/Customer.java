package com.nhnacademy.nhnmart;

import java.util.List;
import java.util.stream.Collectors;

public class Customer {
    private int money = 20000;

    // 고객의 구매 목록
    private final BuyList buyList;
    // 고객의 장바구니
    private Basket basket;

    public Customer(BuyList buyList) {
        this.buyList = buyList;
    }

    // 장바구니를 챙김
    public void bring(Basket basket) {
        this.basket = basket;
    }

    public void pickFoods(FoodStand foodStand) {
        for (BuyList.Item item : buyList.getItems()) {
            long count = foodStand.getFoods()
                    .stream()
                    .filter(food -> food.getName().equals(item.getName()))
                    .count();
            if (count < item.getAmount()) {
                throw new IllegalArgumentException("재고가 부족합니다.");
            } else {
                List<Food> foods = foodStand.getFoods().stream()
                        .filter(food -> food.getName().equals(item.getName()))
                        .limit(item.getAmount())
                        .collect(Collectors.toList());
                basket.addAll(foods);
            }
        }
    }

    public void payTox(Counter counter) {
        counter.count(basket.getFoods(), this.money);
    }
}
