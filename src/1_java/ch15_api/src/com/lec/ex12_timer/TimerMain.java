//20.12.15 kks timer
package com.lec.ex12_timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("����");
		Timer timer = new Timer(true); //true : ���α׷�����Ǹ� timer ����
		TimerTask t1 = new TimerTaskEx1();
		TimerTask t2 = new TimerTaskEx2();
		timer.schedule(t1, 2000); //�и��������� �Է�. 2���Ŀ� �ѹ� ����
		timer.schedule(t2, 500,1000); //0.5�� �� ���� 1�� ����. 
		Thread.sleep(10000);//10�� ���
		System.out.println("��");
	}
}
