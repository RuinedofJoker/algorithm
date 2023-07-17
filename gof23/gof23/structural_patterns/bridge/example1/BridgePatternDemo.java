package gof23.structural_patterns.bridge.example1;

import gof23.structural_patterns.bridge.example1.draw.GreenCircle;
import gof23.structural_patterns.bridge.example1.draw.RedCircle;
import gof23.structural_patterns.bridge.example1.shape.Circle;
import gof23.structural_patterns.bridge.example1.shape.Shape;

public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
