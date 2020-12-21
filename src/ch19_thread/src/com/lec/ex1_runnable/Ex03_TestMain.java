package com.lec.ex1_runnable;

public class Ex03_TestMain {
	public static void main(String[] args) {
		Runnable a = new Ex01_Target();
		Runnable b = new Ex02_Target();
		Thread tA = new Thread(a,"A"); //"A"��� �̸��� thread���� -Ex01_Tatget.run()�� �����ϴ� thread
		Thread tB = new Thread(b,"B"); //"B"��� �̸��� thread���� -Ex02_Tatget.run()�� �����ϴ� thread
		tA.start();
		tB.start();
		for(int i = 0;i<10;i++) {
			System.out.println("����"+Thread.currentThread().getName()+"~"+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
