import java.util.*;

class HashMapNoType {

	public static void main(String [] args) {
		HashMap hs = new HashMap<>();
		Object o = new Object();
		Object o2 = o;
		hs.put(o, 2);
		hs.put(o2, 1);

		System.out.println("result : " + hs.get(o));
	}

}
