package gof23.creational_pattern.factory.shape;

import gof23.creational_pattern.factory.shape.Shape;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("画了个正方型...");
    }
}
