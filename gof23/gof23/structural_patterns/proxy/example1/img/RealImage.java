package gof23.structural_patterns.proxy.example1.img;

public class RealImage implements Image{

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        loadFromDisk();
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(){
        System.out.println("Loading " + fileName);
    }
}
