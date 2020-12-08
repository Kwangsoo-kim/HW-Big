package com.lec.ex13_final;

public class Rabbit extends Animal {
	@Override
	public void running() {
		speed +=30;
		System.out.println("겁나서 마구 뛰어요 현속도 : "+speed);
	}
}
