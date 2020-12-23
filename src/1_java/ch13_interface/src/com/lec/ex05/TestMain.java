package com.lec.ex05;

public class TestMain {
	public static void main(String[] args) {
		TestChildClass c1 = new TestChildClass();
		System.out.println(c1.I1+","+c1.I2);
		System.out.println(c1.I3+","+c1.I11);
		c1.m1();
		c1.m2();
		c1.m3();
		c1.m11();
	}
}
