package com.nhnacademy.nhnmart;

import java.util.Scanner;
import java.util.StringTokenizer;

class NhnMartShell {
    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart();
        System.out.println("NHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요.");

        BuyList buyList = inputBuyListFromShell();

        Customer jordan = new Customer(buyList);
        // 장바구니를 챙긴다.
        jordan.bring(mart.provideBasket());
        // 식품을 담는다.
        jordan.pickFoods(mart.getFoodStand());
        // 카운터에서 계산한다.
        jordan.payTox(mart.getCounter());
    }

    private static BuyList inputBuyListFromShell() {
        Scanner sc = new Scanner(System.in);
        System.out.print("> ");

        BuyList buyList = new BuyList();
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        while (st.hasMoreTokens()) {
            String name = st.nextToken();
            String amount = st.nextToken();
            buyList.add(new BuyList.Item(name, Integer.parseInt(amount)));
        }
        // TODO
        return buyList;
    }
}

public class NhnMart {
    private final FoodStand foodStand = new FoodStand();

    public void prepareMart() {
        fillFoodStand();
    }

    private void fillFoodStand() {
        for (int i = 0; i < 2; i++) {
            foodStand.add(new Food("양파", 1_000));
        }
        for (int i = 0; i < 5; i++) {
            foodStand.add(new Food("계란", 5_000));
        }
        for (int i = 0; i < 10; i++) {
            foodStand.add(new Food("파", 500));
        }
        for (int i = 0; i < 20; i++) {
            foodStand.add(new Food("사과", 2_000));
        }
    }

    public Basket provideBasket() {
        return new Basket();
    }

    public FoodStand getFoodStand() {
        return this.foodStand;
    }

    public Counter getCounter() {
        return new Counter();
    }
}
