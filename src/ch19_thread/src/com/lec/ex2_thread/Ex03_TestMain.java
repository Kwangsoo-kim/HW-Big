package com.lec.ex2_thread;

public class Ex03_TestMain {
	public static void main(String[] args) {
		Thread t1 = new Ex01_Target(); // Thread 생성 - t1.run()을 수행
		t1.setName("A"); // Thread 이름 지정
		Thread t2 = new Ex02_Target(); // Thread 생성 - t2.run()을 수행
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
