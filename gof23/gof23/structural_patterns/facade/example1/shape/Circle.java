package gof23.structural_patterns.facade.example1.shape;

public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("画了个圆...");
    }
}
