package com.lec.ex5_synchronize;

public class Ex02_TestMain {
	public static void main(String[] args) {
		Ex01_Thread target = new Ex01_Thread(); //작업객체 1개 Thread 공유
		Thread t1 = new Thread(target,"A");
		Thread t2 = new Thread(target,"B");
		t1.start();
		t2.start();
		//공동변수를 공유함으로 B객체의 num값이 누적된 것처럼 나옴
		
	}
}
