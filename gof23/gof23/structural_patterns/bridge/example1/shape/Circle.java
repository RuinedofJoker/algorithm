package gof23.structural_patterns.bridge.example1.shape;

import gof23.structural_patterns.bridge.example1.draw.DrawAPI;

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
