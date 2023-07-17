package gof23.structural_patterns.bridge.example1.draw;

public class RedCircle implements DrawAPI{
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("画红色的圆,半径为" + radius + ",坐标:(" + x + "," + y + ")");
    }
}
