package com.lec.ex02;
// �߻�Ŭ������ �Ѱ��̻��� �߻�޼ҵ带 ���´�.
// Super s = new Super();  �Ұ���
// s.method1(); �Ұ���
public abstract class Super {
	public Super() {} //����Ʈ ������
	public abstract void method1(); //�߻�޼ҵ�
	public void method2() {
		System.out.println("Super�� method2()");
	}
}
