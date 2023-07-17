package gof23.creational_pattern.singleton.hungry;

public class SingletonPatternDemo {
    public static void main(String[] args) {
        SingleObject instance = SingleObject.getInstance();
        instance.showMessage();
    }
}
