package com.lec.ex3_accessTest;

public class AccessTest {
	private int privateMember; //���� Ŭ���� �������� ��밡��
	int defaultMember; // ����Ʈ : ���� ��Ű�������� ��밡��
	protected int protectedMember; // ���� ��Ű���� ��ӹ��� ����Ŭ�������� ��밡��
	public int publicMember; // �ܺο��� �ƹ��볪 ��밡��
//�޼ҵ�
	private void privateMethod() {  // ���� Ŭ���� �������� ��밡��
		System.out.println("private �޼ҵ� ȣ��");
	}
	void defaultMethod() { // ���� ��Ű��������
	System.out.println("����Ʈ �޼ҵ� ȣ��");
	}
	protected void protectedMethod() {
		System.out.println("protected �޼ҵ� ȣ��");
	}
	public void publicMethod() {
		System.out.println("public �޼ҵ� ȣ��");
	}

}
