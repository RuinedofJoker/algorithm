package gof23.structural_patterns.decorator.example1;

import gof23.structural_patterns.decorator.example1.shape.Circle;
import gof23.structural_patterns.decorator.example1.shape.Rectangle;
import gof23.structural_patterns.decorator.example1.shape.Shape;
import gof23.structural_patterns.decorator.example1.shape.decorator.RedShapeDecorator;
import gof23.structural_patterns.decorator.example1.shape.decorator.ShapeDecorator;

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();

        ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());

        circle.draw();

        redCircle.draw();
        redRectangle.draw();
    }
}
