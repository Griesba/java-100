import java.lang.reflect.Proxy;

public class ReverseStringProxyFactory {

    public static StringInterface newInstance(String str) {
        return (StringInterface) Proxy.newProxyInstance(ProxyInvocaitonHandlerReverse.class.getClassLoader(),
                new Class[]{StringInterface.class},
                new ProxyInvocaitonHandlerReverse(new StringInterfaceImplementation(str)));
    }
}
