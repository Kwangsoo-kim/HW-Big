package com.lec.ex05;

public class TestClass implements I3{ //I3가 I1,I2를 다중상속 받아서 I3안에 구성내용이 다 있다.

	@Override
	public void m1() {
		System.out.println("상수 I1 : "+I1);
	}

	@Override
	public void m2() {
		System.out.println("상수 I2 : "+I2);
	}

	@Override
	public void m3() {
		System.out.println("상수 I3 : "+I3);
	}

}
