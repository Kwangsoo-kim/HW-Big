package com.lec.ex09_person;

public class TestMain {
	public static void main(String[] args) {
		Person papa = new Person("�ƺ���","�׶���");
		Person mom =new Person("������","������");
		papa.intro();
		mom.intro();
		System.out.println("==========================================");
		Baby b1 = new Baby();
		b1.setNa("�Ʊ��1");
		b1.setCha("�� �� �Ϳ����������������");
		b1.intro();
		Baby b2 = new Baby("�Ʊ��2","�Ϳ���");
		b2.Cry();
	}
}
