package com.lec.ex03;

public abstract class ChildClass extends SuperClass{ 
	// SuperŬ�����κ��� ���� �߻� �޼ҵ� method1()�� �ֱ� ������,
	// �������̵带 �ϴ��� �ڱⰡ �߻�Ŭ������ �ǵ��� �ϸ� �ȴ�.
	@Override
	public void method2() {
		System.out.println("ChildClass�� method2()");
		
	}
	public void method3() {
		System.out.println("ChildClass�� method3()");
	}
}
