import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyInvocationHandlerUpperCase implements InvocationHandler {

    private StringInterfaceImplementation maString;//proxy

    public ProxyInvocationHandlerUpperCase(StringInterfaceImplementation str) {
        maString = str;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String methodName = method.getName();
        Object o = method.invoke(maString, args);
        System.out.println("------------ invocation de la methode " + method.getName() + " ----------------");

        if (method.getName().equals("toString")) {
            maString.setMonString(maString.getString().toUpperCase());
        }

        return o;
    }
}
