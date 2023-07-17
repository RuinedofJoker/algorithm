package gof23.creational_pattern.factory;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        Shape shape;

        ShapeFactory shapeFactory = new ShapeFactory();

        shape = shapeFactory.getShape("square");

        shape.draw();
    }
}
