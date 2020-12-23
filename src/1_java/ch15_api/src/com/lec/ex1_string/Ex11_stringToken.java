package com.lec.ex1_string;

import java.util.StringTokenizer;

public class Ex11_stringToken {
	public static void main(String[] args) {
		String str1 ="������ ���ػ� ������ ������ ������";
		String str2 = "2020/12/14";
		
		StringTokenizer tk1 = new StringTokenizer(str1);// space, \t,\n ������ token����
		StringTokenizer tk2 = new StringTokenizer(str2,"/"); //token���� ���� ��ȣ�Է�
		System.out.println("tk1�� token ���� : "+ tk1.countTokens());
		while(tk1.hasMoreTokens()) {
			System.out.println(tk1.nextToken());
		}
		System.out.println("tk2�� token ���� : "+ tk2.countTokens());
		while(tk2.hasMoreElements()) {
			System.out.println(tk2.nextToken());
		}
	}
}
