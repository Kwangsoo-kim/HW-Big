//201221 kks runnable
package com.lec.ex1_runnable;

import java.lang.annotation.Target;

public class Ex04_TargetTestMain {
	public static void main(String[] args) {
		Ex04_Target t = new Ex04_Target(); //runnable t = new Ex04_Target();
		Thread t1 = new Thread(t,"A"); //"A" 라는 이름의 쓰레드를 생성 -t.run()을 수행하는 쓰레드
		Thread t2 = new Thread(t,"B"); //"B" 라는 이름의 쓰레드를 생성 -t.run()을 수행하는 쓰레드
		t1.start();
		t2.start();
		System.out.println(Thread.currentThread().getName());
		System.out.println("main함수 끝");
	}
}
