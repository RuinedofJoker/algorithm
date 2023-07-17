package gof23.creational_pattern.abstract_factory.example1.factory;

import gof23.creational_pattern.abstract_factory.example1.color.Blue;
import gof23.creational_pattern.abstract_factory.example1.color.Color;
import gof23.creational_pattern.abstract_factory.example1.color.Green;
import gof23.creational_pattern.abstract_factory.example1.color.Red;
import gof23.creational_pattern.abstract_factory.example1.shape.Shape;

public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String colorType) {
        Color color;

        if ("red".equals(colorType)) {
            color = new Red();
        }else if ("green".equals(colorType)) {
            color = new Green();
        }else if ("blue".equals(colorType)) {
            color = new Blue();
        }else {
            throw new RuntimeException("颜色不存在...");
        }

        return color;
    }

    @Override
    public Shape getShape(String shapeType) {
        return null;
    }
}
