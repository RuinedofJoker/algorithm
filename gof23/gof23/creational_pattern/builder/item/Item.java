package gof23.creational_pattern.builder.item;

import gof23.creational_pattern.builder.item.pack.Packing;

public interface Item {
    String name();
    Packing packing();
    float price();
}
