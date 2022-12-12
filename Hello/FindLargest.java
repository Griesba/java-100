import java.util.*;

class FindLargest {
	public static void main(String [] args) {
		List<Integer> in = new ArrayList();
		int i = 0;
		
		while(i < args.length ){
			in.add(Integer.valueOf(args[i++]));
		}
		int max = in.get(0);
		for(int elt : in) {
			if( elt > max) {
				max = elt;
			}
		}

		System.out.println("max is : " + max);
	}
}
