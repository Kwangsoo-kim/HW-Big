//20.12.15 kks example2
package com.lec.ex08_rectangle;

public class Ex04_RectanleMain {
	public static void main(String[] args) {
		Rectanle r1 = new Rectanle();
		Rectanle r2 = new Rectanle(10, 15, "»¡°­");
		Rectanle r3 = new Rectanle(10,15,"»¡°­");
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		System.out.println(r2.equals(r3));
		
	}
}
