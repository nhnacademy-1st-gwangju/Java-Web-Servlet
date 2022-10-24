package com.nhnacademy.nhnmart;

import java.util.ArrayList;

public class FoodStand {
    private final ArrayList<Food> foods = new ArrayList<>();

    public void add(Food onion1) {
        foods.add(onion1);
    }

    public void remove(Food food) {
        foods.remove(food);
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    @Override
    public String toString() {
        return "FoodStand{" +
                "foods=" + foods +
                '}';
    }
}
