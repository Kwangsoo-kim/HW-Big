package com.lec.ex01;

public class InterfaceClass implements InterfaceEx1,InterfaceEx2{

	@Override
	public void method1() {
		System.out.println("���� ������ implements�� Ŭ�������� �ؿ�");
		
	}

	@Override
	public String method2() {
		System.out.println("���� ������ implements�� Ŭ�������� �ؿ�");
		return null;
	}

}
