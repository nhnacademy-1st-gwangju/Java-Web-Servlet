package com.nhnacademy.nhnmart.domain;

import java.util.ArrayList;

public class FoodStand {
    private final ArrayList<Food> foods = new ArrayList<>();

    public void add(Food onion1) {
        foods.add(onion1);
    }

    public void delete() {
        foods.clear();
    }

    public long count(String name) {
        return foods.stream().filter(f -> f.getName().equals(name))
                .count();
    }

    @Override
    public String toString() {
        return "FoodStand{" +
                "foods=" + foods +
                '}';
    }
}
