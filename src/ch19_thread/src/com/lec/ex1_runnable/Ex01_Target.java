package com.lec.ex1_runnable;

public class Ex01_Target implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("�ȳ��ϼ��� - " + i);
			try {
				Thread.sleep(500); // o.5�ʵ��� ������
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
