package com.lec.ex07_toy;

public class Flight implements Imissile,Ilight {
	public Flight() {
		System.out.println(" ����� �Դϴ�.");
		lit();
		misl();
		System.out.println("=======================");
	}

	@Override
	public void lit() {
		System.out.println("�Һ� �߻� �����մϴ�.");
		
	}

	@Override
	public void misl() {
		System.out.println("�̻����� �� �� �ֽ��ϴ�.");
	}
	@Override
	public String toString() {
		
		return "�̻����� �� �� �հ�, �Һ�ݻ簡 ������ ����� ";
	}
}
