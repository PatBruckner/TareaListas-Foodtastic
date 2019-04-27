package com.asiesinc.foodtastic;

import java.util.ArrayList;
import java.util.List;

public class FoodUtils {

    public static List<Food> getFood() {
        List<Food> food = new ArrayList<>();
        food.add(new Food(1, "Burger", R.drawable.burger));
        food.add(new Food(2, "Pizza", R.drawable.pizza));

        return food;
    }
}

