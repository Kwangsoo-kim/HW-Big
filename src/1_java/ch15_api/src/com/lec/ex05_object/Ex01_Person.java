//20.12.15 kks equals override
package com.lec.ex05_object;

public class Ex01_Person {
	public static void main(String[] args) {
		String s1 ="java";
		String s2 = new String("java");
		if(s1.equals(s2)) {
			System.out.println("���� String ��ü��.");
		}else {
			System.out.println("�ٸ� String ��ü��.");
		}
		Person p1 = new Person(031111111111L);
		Person p2 = new Person(031111111111L);
		if(p1.equals(p2)) {
			System.out.println("���� Person ��ü��.");
		}else {
			System.out.println("�ٸ� Person ��ü��.");
		}
	}
}
