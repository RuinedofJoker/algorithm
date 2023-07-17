package gof23.creational_pattern.abstract_factory.example1.factory;

import gof23.creational_pattern.abstract_factory.example1.color.Color;
import gof23.creational_pattern.abstract_factory.example1.shape.Circle;
import gof23.creational_pattern.abstract_factory.example1.shape.Rectangle;
import gof23.creational_pattern.abstract_factory.example1.shape.Shape;
import gof23.creational_pattern.abstract_factory.example1.shape.Square;

public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor(String colorType) {
        return null;
    }

    @Override
    public Shape getShape(String shapeType) {
        Shape shape;

        if ("circle".equals(shapeType)) {
            shape = new Circle();
        }else if ("square".equals(shapeType)) {
            shape = new Square();
        }else if ("rectangle".equals(shapeType)) {
            shape = new Rectangle();
        }else {
            throw new RuntimeException("没有该类型...");
        }

        return shape;
    }
}
