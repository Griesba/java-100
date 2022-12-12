class ReverseAsciiArt {
	
	static class AsciiArt {
		static String printChart(char c) {
			return String.valueOf(c) + "MM";
		}
	}
	
	 static char scanChar(String s) {
		int index = 'A';
		
		while(index <= 'Z') {
			
			if(AsciiArt.printChart((char)index).equals(s)){
				return (char)index;
			}
			index++;
		}
		return '?';
	}

	public static void main(String[] args) {
	
		
		System.out.println(scanChar(args[0]));
	}
}
