package com.lec.loop;

public class Ex05_forBreak {
	public static void main(String[] args) {
		for(int i = 1; i<11; i++) {
			if(i==5) {
				continue; // ���������� ����� ��ɾ�(�������?)
				//break; // �ݺ��� ���� ���������� ��ɾ�
			}
			System.out.print(i+" ");
		}
	}
}
