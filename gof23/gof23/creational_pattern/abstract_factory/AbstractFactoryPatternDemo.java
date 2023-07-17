package gof23.creational_pattern.abstract_factory;

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
