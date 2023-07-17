package gof23.structural_patterns.bridge;

import gof23.structural_patterns.bridge.draw.GreenCircle;
import gof23.structural_patterns.bridge.draw.RedCircle;
import gof23.structural_patterns.bridge.shape.Circle;
import gof23.structural_patterns.bridge.shape.Shape;

public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
