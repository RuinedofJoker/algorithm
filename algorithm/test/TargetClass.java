package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TargetClass implements TargetInterface{
    @Override
    public int foo() {
        System.out.println("目标类foo方法调用了");
        return 1;
    }

    public static void main(String[] args) {
        TargetClass targetClass = new TargetClass();

        final Object[] in = {null};
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(targetClass.getClass().getClassLoader(), targetClass.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object inner, Method method, Object[] args) throws Throwable {
                Object result = method.invoke(targetClass, args);
                in[0] = inner;
                return result;
            }
        });

        proxy.foo();
        System.out.println(in[0] == proxy);
    }
}
