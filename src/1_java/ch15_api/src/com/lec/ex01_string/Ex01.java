package com.lec.ex01_string;

public class Ex01 {
	public static void main(String[] args) {
		String str1 = "java";
		String str2 = "java";
		String str3 = new String("java"); //������ ��ü����
		String srt4 = new String("java");
		if(str1==str2) {
			System.out.println("st1��str2�� ���� �ּ�");
		}else {
			System.out.println("str1��str2�� �ٸ� �ּ�");
		}
		str1 ="java2";
		if(str1==str2) {
			System.out.println("st1��str2�� ���� �ּ�");
		}else {
			System.out.println("str1��str2�� �ٸ� �ּ�");
		}
		if(str1==str3) {
			System.out.println("str1�� str3�� ���� �ּ�");
		}else {
			System.out.println("str1��str3�� �ٸ� �ּ�");
		}
		System.out.println(str1.hashCode());
		System.out.println("str2�� str3�� ���� ��Ʈ���̳�?"+(str2.equals(str3)? "����" : "�ٸ���"));
	}
}