package gof23.structural_patterns.proxy.example1.proxy;

import gof23.structural_patterns.proxy.example1.img.Image;
import gof23.structural_patterns.proxy.example1.img.RealImage;

public class ProxyImage implements Image {

    private Image realImage;

    public ProxyImage(String fileName){
        realImage = new RealImage(fileName);
    }

    @Override
    public void display() {
        System.out.println("增强方法...");
        realImage.display();
        System.out.println("增强方法...");
    }
}
