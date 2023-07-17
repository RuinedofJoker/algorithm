package gof23.structural_patterns.bridge.shape;

import gof23.structural_patterns.bridge.draw.DrawAPI;

public class Circle extends Shape{

    int x;
    int y;
    int radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}
