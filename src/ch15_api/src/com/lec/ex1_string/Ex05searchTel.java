package com.lec.ex1_string;

import java.util.Scanner;

public class Ex05searchTel {
	public static void main(String[] args) {
		String[] tels = {"010-1234-1234",
				"010-9999-9999",
				"010-8888-8888"};
		Scanner sc= new Scanner(System.in);
		String searchTel;
		int idx; //��ȭ��ȣ�� �ߺ��� ���� ��
		System.out.println("��ȭ��ȣ ���ڸ��� �Է����ּ��� : ");
		searchTel = sc.next();
		for(idx=0;idx<tels.length;idx++) {
			String t = tels[idx];
			String post = t.substring(t.lastIndexOf("-")+1);
			if(searchTel.equals(post)) {
				System.out.println(t);
				break;
			}//if
		}//for
		if(idx==tels.length) {
			System.out.println("�Է��Ͻ� ��ȭ��ȣ�� ���� ��ȣ�Դϴ�.");
		}
	}//main
}//class
