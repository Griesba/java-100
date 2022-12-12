class EnumCompare {

	enum Planet {EART, MARS};
	public static void main(String [] args) {
		System.out.println("==" + (Planet.EART == Planet.EART));
		System.out.println("equals" + Planet.EART.equals(Planet.MARS));
	}
}
