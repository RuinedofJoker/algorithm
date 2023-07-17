package gof23.creational_pattern.abstract_factory.example1.factory;

import gof23.creational_pattern.abstract_factory.example1.color.Color;
import gof23.creational_pattern.abstract_factory.example1.shape.Shape;

public abstract class AbstractFactory {
    public abstract Color getColor(String colorType);
    public abstract Shape getShape(String shapeType);
}
