package com.lec.ex13_final;

public class Animal {
	protected int speed;
	public void running() {
		speed+=5;
		System.out.println("�ٰ� �־�� ���ӵ� : "+ speed);
	}
	public final void stop() {  //final ��� override �Ұ�.
		speed=0;
		System.out.println("����!");
	}
}
