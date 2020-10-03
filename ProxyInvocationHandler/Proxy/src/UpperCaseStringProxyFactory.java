import java.lang.reflect.Proxy;

public class UpperCaseStringProxyFactory {
    public static StringInterface newInstance(String str) {
        return  (StringInterface) Proxy.newProxyInstance(ProxyInvocationHandlerUpperCase.class.getClassLoader(),
                new Class[]{StringInterface.class},
                new ProxyInvocationHandlerUpperCase(new StringInterfaceImplementation(str)));
    }
}
