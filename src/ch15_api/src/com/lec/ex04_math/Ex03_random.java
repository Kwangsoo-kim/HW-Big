//20.12.15 kks random api
package com.lec.ex04_math;

import java.util.Random;

public class Ex03_random {
	public static void main(String[] args) {
		System.out.println((int)(Math.random()*45)+1);
		Random rd = new Random();
		System.out.println("int ���� : "+rd.nextInt());    //����
		System.out.println("0~100���� int ���� : "+rd.nextInt(101));
		System.out.println("0~44���� int ���� : "+rd.nextInt(45));
		System.out.println("1~45���� int ���� : "+(rd.nextInt(45)+1));
		System.out.println("double ���� : "+rd.nextDouble()); //Math.random()�� ����.
		System.out.println("T/F�߿� �ϳ� ���� : "+rd.nextBoolean());
	}
}
