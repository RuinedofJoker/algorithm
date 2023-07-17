package gof23.creational_pattern.builder;

import gof23.creational_pattern.builder.meal.Meal;
import gof23.creational_pattern.builder.meal.MealBuilder;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder builder = new MealBuilder();

        Meal meal = builder.prepareNonVegMeal().build();

        System.out.println("价格为 : " + meal.getCost());
        meal.showItems();
    }
}
