package gof23.creational_pattern.abstract_factory.color;

import gof23.creational_pattern.abstract_factory.color.Color;

public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("画上了绿色...");
    }
}
