package gof23.structural_patterns.decorator.example1.shape.decorator;

import gof23.structural_patterns.decorator.example1.shape.Shape;

public abstract class ShapeDecorator implements Shape {

    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
