package com.lec.ex2_thread;

public class Ex03_TestMain {
	public static void main(String[] args) {
		Thread t1 = new Ex01_Target(); // Thread ���� - t1.run()�� ����
		t1.setName("A"); // Thread �̸� ����
		Thread t2 = new Ex02_Target(); // Thread ���� - t2.run()�� ����
		t2.setName("B");
		t1.start();
		t2.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("main~");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
