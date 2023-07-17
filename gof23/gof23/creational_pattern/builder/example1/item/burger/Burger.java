package gof23.creational_pattern.builder.example1.item.burger;

import gof23.creational_pattern.builder.example1.item.Item;
import gof23.creational_pattern.builder.example1.item.pack.Packing;
import gof23.creational_pattern.builder.example1.item.pack.Wrapper;

public abstract class Burger implements Item {
    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
