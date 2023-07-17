package gof23.creational_pattern.builder.example1.item;

import gof23.creational_pattern.builder.example1.item.pack.Packing;

public interface Item {
    String name();
    Packing packing();
    float price();
}
