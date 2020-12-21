//201221 kks runnable
package com.lec.ex1_runnable;

public class Ex03_TestMain {
	public static void main(String[] args) {
		Runnable a = new Ex01_Target();
		Runnable b = new Ex02_Target();
		Thread tA = new Thread(a,"A"); //"A"라는 이름의 thread생성 -Ex01_Tatget.run()을 수행하는 thread
		Thread tB = new Thread(b,"B"); //"B"라는 이름의 thread생성 -Ex02_Tatget.run()을 수행하는 thread
		tA.start();
		tB.start();
		for(int i = 0;i<10;i++) {
			System.out.println("나는"+Thread.currentThread().getName()+"~"+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
