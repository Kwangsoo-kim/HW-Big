package com.lec.ex5_momchild;

public class ChildTest {
	public static void main(String[] args) {
		Child ch1 = new Child("ù° ������");
		Child ch2 = new Child("��° ������");
		Child ch3 = new Child("��° ������");
		ch1.takeMoney(1000);
		ch1.takeMoney(1000);
		ch2.takeMoney(1000);
		ch3.takeMoney(1000);
		System.out.println("ù ° ���� ����"+ ch1.momPouch.money);
		System.out.println("�� ° ���� ����"+ ch2.momPouch.money);
		System.out.println("�� ° ���� ����"+ ch3.momPouch.money);
		System.out.println("static ���� ������ : "+ Child.momPouch.money);
	}
}
