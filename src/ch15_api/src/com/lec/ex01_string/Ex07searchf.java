package com.lec.ex01_string;

import java.util.Scanner;

//��ȭ��ȣ ���ڸ��� ģ��ã��
public class Ex07searchf {
	public static void main(String[] args) {
		Friend[] fs = { new Friend("ȫ�浿", "000-1111-1111", "5-12"), new Friend("�ű浿", "010-8888-8888", "01-10"),
				new Friend("��浿", "010-2222-2222", "03-12") };
		// ã�� ģ���� ��ȭ ��ȣ ���ڸ��� �Է¹޴´�.
		// fs�迭���� �ش� ��ȭ��ȣ ���ڸ��� ���� ģ���� ������ ģ���� ���
		// ������ ���ٰ� Ǯ��
		int i;
		String ff;
		Scanner sc = new Scanner(System.in);
		System.out.println("ģ���� ��ȭ ��ȣ ���ڸ��� �Է��ϼ���");
		ff = sc.next();
		for (i = 0; i < fs.length; i++) {
			String t = fs[i].getTel();
			String p = t.substring(t.lastIndexOf("-") + 1);

			if (p.equals(ff)) {
				System.out.println(fs[i]);
				fs[i].print();
				break;
			}
		}
		if (i == fs.length) {
			System.out.println("�ش��ȣ ģ���� �����ϴ�.");
		}
	}
}
