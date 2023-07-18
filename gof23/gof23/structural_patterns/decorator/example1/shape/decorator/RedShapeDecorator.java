package gof23.structural_patterns.decorator.example1.shape.decorator;

import gof23.structural_patterns.decorator.example1.shape.Shape;

public class RedShapeDecorator extends ShapeDecorator{

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder();
    }

    private void setRedBorder(){
        System.out.println("添加颜色:红色..");
    }
}
