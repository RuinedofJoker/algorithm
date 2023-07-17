package gof23.creational_pattern.builder.example1;

import gof23.creational_pattern.builder.example1.meal.Meal;
import gof23.creational_pattern.builder.example1.meal.MealBuilder;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder builder = new MealBuilder();

        Meal meal = builder.prepareNonVegMeal().build();

        System.out.println("价格为 : " + meal.getCost());
        meal.showItems();
    }
}
