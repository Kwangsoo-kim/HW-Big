package com.lec.ex02;

public class TestMain {
	public static void main(String[] args) {
//		Super t; //������ �ϳ� ��ӹ޴� Child�� ��ü�� �������Ѵ�. Super�� ��ü�� ����� ���� �Ұ���.
//		Super s = new Super() {// �ȵ���̵尳�߿��� ����� �� �ִ�.
//			
//			@Override
//			public void method1() {
//				System.out.println("�ȵ���̵忡���� �̷� �� ����");
//				
//			}
//		};
//		s.method1();
		Super c1 = new Child();
		c1.method1();
		c1.method2();
		//c1.method3(); �Ұ��� - Super Ÿ���̶� Super�� �͸� ����
		Child c2 = new Child();
		c2.method2();
		c2.method1();
		c2.method3();
	}
}
