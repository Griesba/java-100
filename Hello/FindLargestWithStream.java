import java.util.*;

class FindLargestWithStream {

	public static void main(String [] args) {
		int max = Arrays.asList(args).stream()
			.mapToInt(s -> Integer.valueOf(s)).max()
			.orElseThrow(() -> new RuntimeException("No max found"));

		
		System.out.println("max is : " + max);
	}
}
