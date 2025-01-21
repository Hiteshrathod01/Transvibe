package com;
import java.util.Random;

public class Accountnum {
	
	public static int generateacc() {
		Random rn = new Random();
		int acc = rn.nextInt(9999999,999999999);
		return acc;
	}

}
