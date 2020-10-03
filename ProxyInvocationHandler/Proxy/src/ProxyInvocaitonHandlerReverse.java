import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyInvocaitonHandlerReverse implements InvocationHandler {

    private StringInterfaceImplementation monString;//proxy

    public ProxyInvocaitonHandlerReverse(StringInterfaceImplementation monString) {
        this.monString = monString;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();

        System.out.println("------------ invocation de la methode "+methodName+" ----------------");

        if (methodName.equals("subString")) {
            char[] initial = monString.getString().toCharArray();
            String reverse = new String();
            for (int i = initial.length -1; i >= 0 ; i--) {
                reverse += initial[i];
            }
            monString.setMonString(reverse);
        }

        return method.invoke(monString, args);
    }
}
