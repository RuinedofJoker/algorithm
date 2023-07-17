package gof23.creational_pattern.singleton.lazy;

public class SingleObject {
    private static volatile SingleObject instance;


    private SingleObject(){}

    public static SingleObject getInstance() {
        if (instance == null) {
            synchronized (SingleObject.class) {
                if (instance == null) {
                    instance = new SingleObject();
                }
            }
        }
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }
}
