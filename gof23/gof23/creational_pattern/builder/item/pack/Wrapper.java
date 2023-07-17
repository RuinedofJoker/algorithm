package gof23.creational_pattern.builder.item.pack;

import gof23.creational_pattern.builder.item.pack.Packing;

public class Wrapper implements Packing {
    @Override
    public String pack() {
        return "Wrapper";
    }
}
