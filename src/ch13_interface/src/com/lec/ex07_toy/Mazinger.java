package com.lec.ex07_toy;

public class Mazinger implements Imissile, Imovearmleg {
	public Mazinger() {
		System.out.println("��¡�� �Դϴ�.");
		mal();
		misl();
		System.out.println("=======================");
	}

	@Override
	public void mal() {
		System.out.println("�� �ٸ��� ������ �� �ֽ��ϴ�.");
	}

	@Override
	public void misl() {
		System.out.println("�̻����� �� �� �ֽ��ϴ�.");

	}
	@Override
	public String toString() {
		
		return "�ȴٸ��� �����̰� �̻����� �� �� �ִ� ��¡�� ���� ";
	}

}
