package gof23.creational_pattern.abstract_factory.color;

import gof23.creational_pattern.abstract_factory.color.Color;

public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("画上了蓝色...");
    }
}
