//201221 kks threadN_objectN
package com.lec.ex4_threadN_objectN;

//Thread N개 객체 1개 공유 - Runnable을 이용
public class Ex01_Thread implements Runnable {
	private int num; // 공유변수

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			String threadName = Thread.currentThread().getName();
			if (threadName.equals("A")) {
				System.out.println("~ ~ ~ A 수행중 ~ ~ ~");
				num++;
			}
			System.out.println(threadName + "의 num = " + num);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
