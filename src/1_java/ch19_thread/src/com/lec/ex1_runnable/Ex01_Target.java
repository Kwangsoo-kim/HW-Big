//201221 kks runnable
package com.lec.ex1_runnable;

public class Ex01_Target implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("안녕하세요 - " + i);
			try {
				Thread.sleep(500); // o.5초동안 대기상태
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
