package gof23.creational_pattern.abstract_factory.shape;

import gof23.creational_pattern.abstract_factory.shape.Shape;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("画了个圆...");
    }
}
