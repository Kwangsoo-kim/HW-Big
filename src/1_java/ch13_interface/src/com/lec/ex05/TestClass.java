package com.lec.ex05;

public class TestClass implements I3{ //I3�� I1,I2�� ���߻�� �޾Ƽ� I3�ȿ� ���������� �� �ִ�.

	@Override
	public void m1() {
		System.out.println("��� I1 : "+I1);
	}

	@Override
	public void m2() {
		System.out.println("��� I2 : "+I2);
	}

	@Override
	public void m3() {
		System.out.println("��� I3 : "+I3);
	}

}
