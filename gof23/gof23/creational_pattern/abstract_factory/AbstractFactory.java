package gof23.creational_pattern.abstract_factory;

public abstract class AbstractFactory {
    public abstract Color getColor(String colorType);
    public abstract Shape getShape(String shapeType);
}
