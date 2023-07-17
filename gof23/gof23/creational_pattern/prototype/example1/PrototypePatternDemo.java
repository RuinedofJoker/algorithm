package gof23.creational_pattern.prototype.example1;

public class PrototypePatternDemo {
    public static void main(String[] args) {
        Shape clonedShape = null;
        try {
            clonedShape = ShapeCache.getShape("1");
            System.out.println("Shape : " + clonedShape.getType());

            Shape clonedShape2 = ShapeCache.getShape("2");
            System.out.println("Shape : " + clonedShape2.getType());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
