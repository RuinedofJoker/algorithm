package gof23.creational_pattern.builder.item.burger;

import gof23.creational_pattern.builder.item.Item;
import gof23.creational_pattern.builder.item.pack.Packing;
import gof23.creational_pattern.builder.item.pack.Wrapper;

public abstract class Burger implements Item {
    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
