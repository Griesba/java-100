public class DebugProxy {

    public static void main(String[] args) {
        String str1 = "  Ma phrase 1 ";
        System.out.println(str1);
        System.out.println(str1.hashCode());
        System.out.println("sous chaine: "+str1.substring(5));
        System.out.println(str1.getClass());

        System.out.println("##########################################");
        StringInterface str2 = UpperCaseStringProxyFactory.newInstance(str1);
        System.out.println(str2);
        System.out.println(str2.hashCode());
        System.out.println("sous chaine: "+str2.substring(5));
        System.out.println(str2.getClass());

        System.out.println("##########################################");
        StringInterface str3 = ReverseStringProxyFactory.newInstance(str1);
        System.out.println(str3);
        System.out.println(str3.hashCode());
        System.out.println("sous chaine: "+str3.substring(5));
        System.out.println(str3.getClass());
    }
}
