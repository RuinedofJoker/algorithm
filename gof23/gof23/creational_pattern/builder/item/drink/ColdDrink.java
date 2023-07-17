package gof23.creational_pattern.builder.item.drink;

import gof23.creational_pattern.builder.item.pack.Bottle;
import gof23.creational_pattern.builder.item.Item;
import gof23.creational_pattern.builder.item.pack.Packing;

public abstract class ColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
