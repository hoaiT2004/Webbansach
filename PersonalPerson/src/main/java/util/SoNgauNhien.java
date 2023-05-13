package util;

import java.util.Random;

public class SoNgauNhien {
	public static String soNgauNhien() {
		Random rd = new Random();
		String n1 = rd.nextInt(10)+"";
		String n2 = rd.nextInt(10)+"";
		String n3 = rd.nextInt(10)+"";
		String n4 = rd.nextInt(10)+"";
		String n5 = rd.nextInt(10)+"";
		String n6 = rd.nextInt(10)+"";
		String res = n1 + n2 + n3 + n4 + n5 + n6;
		return res;
	}
	public static void main(String[] args) {
		System.out.println(soNgauNhien());	
	}
}
