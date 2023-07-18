package gof23.structural_patterns.facade.example1.shape;

public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("画了个正方形...");
    }
}
