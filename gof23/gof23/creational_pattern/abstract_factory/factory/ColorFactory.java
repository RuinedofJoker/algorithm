package gof23.creational_pattern.abstract_factory.factory;

import gof23.creational_pattern.abstract_factory.color.Blue;
import gof23.creational_pattern.abstract_factory.color.Color;
import gof23.creational_pattern.abstract_factory.color.Green;
import gof23.creational_pattern.abstract_factory.color.Red;
import gof23.creational_pattern.abstract_factory.shape.Shape;

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
