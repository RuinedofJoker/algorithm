package gof23.creational_pattern.abstract_factory.example1;

import gof23.creational_pattern.abstract_factory.example1.color.Color;
import gof23.creational_pattern.abstract_factory.example1.factory.AbstractFactory;
import gof23.creational_pattern.abstract_factory.example1.factory.FactoryProducer;
import gof23.creational_pattern.abstract_factory.example1.shape.Shape;

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
