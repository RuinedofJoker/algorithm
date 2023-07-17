package gof23.creational_pattern.abstract_factory;

import gof23.creational_pattern.abstract_factory.color.Color;
import gof23.creational_pattern.abstract_factory.factory.AbstractFactory;
import gof23.creational_pattern.abstract_factory.factory.FactoryProducer;
import gof23.creational_pattern.abstract_factory.shape.Shape;

public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        AbstractFactory colorFactory = FactoryProducer.getFactory("color");
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");

        Color red = colorFactory.getColor("red");
        Shape square = shapeFactory.getShape("square");

        red.fill();
        square.draw();
    }
}
