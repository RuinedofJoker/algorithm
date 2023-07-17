package gof23.creational_pattern.factory;

import gof23.creational_pattern.factory.shape.Circle;
import gof23.creational_pattern.factory.shape.Rectangle;
import gof23.creational_pattern.factory.shape.Shape;
import gof23.creational_pattern.factory.shape.Square;

public class ShapeFactory {
    Shape getShape(String shapeType) {
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
