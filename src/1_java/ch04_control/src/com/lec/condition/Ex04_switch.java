package com.lec.condition;

public class Ex04_switch {
	public static void main(String[] args) {
		int n1 = 2;
		//����ġ�� if �� ���������� ������ ���ξ��ϰ�, ������ ������ string�� �� �� �ִ�
		switch(n1) {
		case 1:
			System.out.println("�ֻ��� 1"); break;
		case 2:
			System.out.println("�ֻ��� 2"); break;
		case 3:
			System.out.println("�ֻ��� 3"); break;
		default:
			System.out.println("�� ��"); break; //break�� �˸´� ������ ������ �� ���Ǹ� �����ϰ� ���α׷��� ������. �� ����.
		}
	}
}
