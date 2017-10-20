package org.zbq.design;

class Sing {
	private static Sing sing = new Sing();
	public Sing() {
		
	}
	
	public static Sing getInstance() {
		return sing;
	}
}

public class Sington {

	public static void main(String[] args) {
		Sing s1 = Sing.getInstance();
		Sing s2 = Sing.getInstance();

		System.out.println(s1 == s2);
	}

}


