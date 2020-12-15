package com.lec.ex01_string;

public class Ex09_stringBuffer {
	public static void main(String[] args) {
		StringBuilder strB = new StringBuilder("abc");
		System.out.println(strB);
		strB.append("def");
		System.out.println(strB);
		strB.insert(3, "aaa"); // 3���ε����� "aaa"�߰� 
		System.out.println(strB);
		strB.delete(3,6); //3���ε������� 6���ε��� �� ��������
		System.out.println(strB);
		int capacitysize = strB.capacity(); //����ũ��
		System.out.println("����ũ�� : "+capacitysize);
		System.out.println("�� �ؽ��ڵ� : "+strB.hashCode());
		strB.append("01234123412341");
		capacitysize = strB.capacity();
		System.out.println("����ũ�� ���� : "+capacitysize);
		System.out.println("������ strB�� �ؽ��ڵ� : "+ strB.hashCode());
		//����ũ�⸦ ���������� �ø���
		strB.ensureCapacity(1000);
		capacitysize = strB.capacity();
		System.out.println("����ũ�� ���� : "+capacitysize);
		System.out.println("������ strB�� �ؽ��ڵ� : "+ strB.hashCode());
	}
}
