package com.lec.loop;

//1~20������ �������� ���
public class Ex02_for {
	public static void main(String[] args) {
		int tot = 0; // ������ ���� �Ѱ��� �����.
//		for (int i = 1; i <= 20; i++) {// tot ������ i ���� ��� ����
//			tot = tot + i;
//		}
//		System.out.println("1~20������ �������� : " + tot);

//1+2+3+4+5+6+...+20 =210���� ����ϴ� ���
		for (int i = 1; i < 21; i++) {
			tot = tot + i;
			if (i != 20) {
				System.out.print(i + "+");
			} else {
				System.out.print(i + "=");
			}
		}
		System.out.println(tot);
	}
}
