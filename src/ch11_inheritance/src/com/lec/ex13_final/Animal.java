package com.lec.ex13_final;

public class Animal {
	protected int speed;
	public void running() {
		speed+=5;
		System.out.println("뛰고 있어요 현속도 : "+ speed);
	}
	public final void stop() {  //final 사용 override 불가.
		speed=0;
		System.out.println("멈춤!");
	}
}
