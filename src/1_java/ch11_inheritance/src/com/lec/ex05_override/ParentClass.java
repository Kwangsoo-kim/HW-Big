package com.lec.ex05_override;

public class ParentClass {
	//�����ε� : ���� �̸��� ������,�żҵ� ����Ÿ���� �ٸ��� �ߺ����� ����.
	//�����ڰ� 2�� :  ������ �Լ��� �����ε�overloading(�Լ��� �ߺ�����)
	//method2�� 2�� : �޼ҵ� �Լ��� �����ε�(�Ű����� ��ȯ���� ����)
	public ParentClass() {
		System.out.println("P�Ű����� ���� ������");
	}
	public ParentClass(int i) {
		System.out.println("P�Ű����� �ִ� ������");
	}
	public void method1() {
		System.out.println("Parent�� method1()");
	}
	public void method2() {
		System.out.println("Parent�� method2()");
	}
	public void method2(int i) {
		
	}
}
