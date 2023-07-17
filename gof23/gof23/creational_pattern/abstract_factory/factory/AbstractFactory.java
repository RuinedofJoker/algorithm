package gof23.creational_pattern.abstract_factory.factory;

import gof23.creational_pattern.abstract_factory.color.Color;
import gof23.creational_pattern.abstract_factory.shape.Shape;

public abstract class AbstractFactory {
    public abstract Color getColor(String colorType);
    public abstract Shape getShape(String shapeType);
}
