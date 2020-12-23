//20.12.15 kks timer
package com.lec.ex12_timer;

import java.util.TimerTask;

public class TimerTaskEx1 extends TimerTask{
	//override 함수 run에 작업정의
	@Override
	public void run() {
		System.out.println("●●●●●●●●●●작업1 : 2초후에 한번 예정");
	}

}
