package gof23.creational_pattern.factory.example1;

import gof23.creational_pattern.factory.example1.shape.Circle;
import gof23.creational_pattern.factory.example1.shape.Rectangle;
import gof23.creational_pattern.factory.example1.shape.Shape;
import gof23.creational_pattern.factory.example1.shape.Square;

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
