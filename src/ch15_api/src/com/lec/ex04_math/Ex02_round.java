//20.12.15 kks math api
package com.lec.ex04_math;

public class Ex02_round {
	public static void main(String[] args) {
		System.out.println("�Ҽ������� �ݿø�, �ø�, ����");
		System.out.println("9.12�� �ø�  : "+Math.ceil(9.12));  //double��
		System.out.println("9.12�� �ݿø�  : "+Math.round(9.12)); //int ��
		System.out.println("9.12�� ����  : "+Math.floor(9.12)); //double ��
		System.out.println("�Ҽ��� ���ڸ����� �ݿø�,�ø�,����");
		System.out.println("9.15�� �ø� : "+Math.ceil(9.15*10)/10);
		System.out.println("9.15�� �ݿø� : "+Math.round(9.15*10)/10.0);
		System.out.println("9.15�� ���� : "+Math.floor(9.15*10)/10);
		System.out.println("���� �ڸ����� �ݿø� , �ø� ,���� ");
		System.out.println("85�� �ø� : "+Math.ceil(85/10.0)*10);
		System.out.println("85�� �ݿø�  : "+Math.round(85/10.0)*10);
		System.out.println("85�� ���� : "+Math.floor(85/10.0)*10);
	}
}
