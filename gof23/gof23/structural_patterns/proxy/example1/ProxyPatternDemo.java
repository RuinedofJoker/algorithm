package gof23.structural_patterns.proxy.example1;

import gof23.structural_patterns.proxy.example1.img.Image;
import gof23.structural_patterns.proxy.example1.proxy.ProxyImage;

public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        image.display();
    }
}
