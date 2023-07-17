package gof23.creational_pattern.abstract_factory.factory;

public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if ("shape".equals(choice)) {
            return new ShapeFactory();
        }else if ("color".equals(choice)) {
            return new ColorFactory();
        }else {
            throw new RuntimeException("工厂不存在...");
        }
    }
}
