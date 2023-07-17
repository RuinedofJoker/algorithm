package gof23.creational_pattern.builder.example1.meal;

import gof23.creational_pattern.builder.example1.item.Item;
import gof23.creational_pattern.builder.example1.item.burger.ChickenBurger;
import gof23.creational_pattern.builder.example1.item.burger.VegBurger;
import gof23.creational_pattern.builder.example1.item.drink.Coke;
import gof23.creational_pattern.builder.example1.item.drink.Pepsi;

public class MealBuilder{
    private Meal meal;

    public MealBuilder() {
        this.meal = new Meal();
    }

    public MealBuilder addItem(Item item) {
        meal.addItem(item);
        return this;
    }

    public MealBuilder prepareVegMeal() {
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return this;
    }

    public MealBuilder prepareNonVegMeal() {
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return this;
    }

    public Meal build() {
        return meal;
    }
}
