package com.lec.ex07_toy;

public class Bear implements Imovearmleg{
	public Bear() {
		System.out.println("������ �Դϴ�.");
		mal();
		System.out.println("=======================");
	}
	@Override
	public void mal() {
		System.out.println("�� �ٸ��� ������ �� �ִ�.");
	}
	@Override
	public String toString() {
		
		return "�ȴٸ� �����̴� ������ ";
	}
}
