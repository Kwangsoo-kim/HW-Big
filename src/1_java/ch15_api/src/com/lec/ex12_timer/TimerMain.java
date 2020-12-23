//20.12.15 kks timer
package com.lec.ex12_timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("시작");
		Timer timer = new Timer(true); //true : 프로그램종료되면 timer 종료
		TimerTask t1 = new TimerTaskEx1();
		TimerTask t2 = new TimerTaskEx2();
		timer.schedule(t1, 2000); //밀리세컨으로 입력. 2초후에 한번 실행
		timer.schedule(t2, 500,1000); //0.5초 후 부터 1초 마다. 
		Thread.sleep(10000);//10초 대기
		System.out.println("끝");
	}
}
