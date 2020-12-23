//20.12.15 kks random api
package com.lec.ex04_math;

import java.util.Random;

public class Ex03_random {
	public static void main(String[] args) {
		System.out.println((int)(Math.random()*45)+1);
		Random rd = new Random();
		System.out.println("int 난수 : "+rd.nextInt());    //정수
		System.out.println("0~100까지 int 난수 : "+rd.nextInt(101));
		System.out.println("0~44까지 int 난수 : "+rd.nextInt(45));
		System.out.println("1~45까지 int 난수 : "+(rd.nextInt(45)+1));
		System.out.println("double 난수 : "+rd.nextDouble()); //Math.random()과 동일.
		System.out.println("T/F중에 하나 선택 : "+rd.nextBoolean());
	}
}
