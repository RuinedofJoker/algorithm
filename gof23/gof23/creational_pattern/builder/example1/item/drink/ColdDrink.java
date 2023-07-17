package gof23.creational_pattern.builder.example1.item.drink;

import gof23.creational_pattern.builder.example1.item.pack.Bottle;
import gof23.creational_pattern.builder.example1.item.Item;
import gof23.creational_pattern.builder.example1.item.pack.Packing;

public abstract class ColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
