package gof23.structural_patterns.facade.example1.facade;

import gof23.structural_patterns.facade.example1.shape.Circle;
import gof23.structural_patterns.facade.example1.shape.Rectangle;
import gof23.structural_patterns.facade.example1.shape.Shape;
import gof23.structural_patterns.facade.example1.shape.Square;

public class ShapeMaker {
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public ShapeMaker() {
        this.circle = new Circle();
        this.rectangle = new Rectangle();
        this.square = new Square();
    }

    public void drawCircle(){
        circle.draw();
    }
    public void drawRectangle(){
        rectangle.draw();
    }
    public void drawSquare(){
        square.draw();
    }
}
