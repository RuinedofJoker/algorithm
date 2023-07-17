package gof23.creational_pattern.prototype;

import java.util.concurrent.ConcurrentHashMap;

public class ShapeCache {
    private static final ConcurrentHashMap<String, Shape> shapeMap = new ConcurrentHashMap();
    static {
        Square square = new Square();
        square.setId("1");
        shapeMap.put(square.getId(),square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("2");
        shapeMap.put(rectangle.getId(),rectangle);
    }

    public static Shape getShape(String shapeId) throws CloneNotSupportedException {
        return (Shape) shapeMap.get(shapeId).clone();
    }
}
