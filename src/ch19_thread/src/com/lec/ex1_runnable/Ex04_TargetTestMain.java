package com.lec.ex1_runnable;

import java.lang.annotation.Target;

public class Ex04_TargetTestMain {
	public static void main(String[] args) {
		Ex04_Target t = new Ex04_Target(); //runnable t = new Ex04_Target();
		Thread t1 = new Thread(t,"A"); //"A" ��� �̸��� �����带 ���� -t.run()�� �����ϴ� ������
		Thread t2 = new Thread(t,"B"); //"B" ��� �̸��� �����带 ���� -t.run()�� �����ϴ� ������
		t1.start();
		t2.start();
		System.out.println(Thread.currentThread().getName());
		System.out.println("main�Լ� ��");
	}
}
