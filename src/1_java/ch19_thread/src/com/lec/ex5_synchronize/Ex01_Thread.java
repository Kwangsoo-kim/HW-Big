//201221 kks synchronize
package com.lec.ex5_synchronize;

//Thread N개 객체 1개 공유 - Runnable을 이용
public class Ex01_Thread implements Runnable {
	private int num; // 공유변수

	@Override

	public void run() { // synchronized run()수행중에는 아무것도 끼어들지 못한다.
		for (int i = 0; i < 10; i++) {
			out();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private synchronized void out() {
		String threadName = Thread.currentThread().getName();
		if (threadName.equals("A")) {
			System.out.println("~ ~ ~ A 수행중 ~ ~ ~");
			num++;
		}
		System.out.println(threadName + "의 num = " + num);
	}
}
