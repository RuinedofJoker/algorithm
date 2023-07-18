package gof23.structural_patterns.flyweight.example1.shape;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ShapeFactory {
    private static final ConcurrentHashMap<String, Shape> circleMap = new ConcurrentHashMap<>();

    public static Shape getCircle(String color) {
        Shape circle = circleMap.get(color);

        if (circle == null) {
            synchronized (circleMap) {
                circle = circleMap.get(color);
                if (circle == null) {
                    circle = new Circle(color);
                    circleMap.put(color, circle);
                }
            }
        }

        return circle;
    }
}
