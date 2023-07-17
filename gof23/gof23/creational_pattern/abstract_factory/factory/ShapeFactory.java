package gof23.creational_pattern.abstract_factory.factory;

import gof23.creational_pattern.abstract_factory.color.Color;
import gof23.creational_pattern.abstract_factory.factory.AbstractFactory;
import gof23.creational_pattern.abstract_factory.shape.Circle;
import gof23.creational_pattern.abstract_factory.shape.Rectangle;
import gof23.creational_pattern.abstract_factory.shape.Shape;
import gof23.creational_pattern.abstract_factory.shape.Square;

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
