package com.lec.ex05_override;

public class ChildClass extends ParentClass {
	public ChildClass() {
		System.out.println("C �Ű����� ���� ������");
	}
	public ChildClass(int i) {
		System.out.println("C �Ű����� �ִ� ������");
	}
	@Override
	public void method1() {//�������̵�(�Լ��� ������)
		System.out.println("Child�� method1()");
	}
	public void method3() {
		System.out.println("Child�� method3()");
	}
	
}