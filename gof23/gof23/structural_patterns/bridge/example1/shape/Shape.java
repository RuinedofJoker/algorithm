package gof23.structural_patterns.bridge.example1.shape;

import gof23.structural_patterns.bridge.example1.draw.DrawAPI;

public abstract class Shape {
    protected DrawAPI drawAPI;

    public Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}
