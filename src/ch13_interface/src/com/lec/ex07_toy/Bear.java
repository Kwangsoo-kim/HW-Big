package com.lec.ex07_toy;

public class Bear implements Imovearmleg{
	public Bear() {
		System.out.println("곰돌이 입니다.");
		mal();
		System.out.println("=======================");
	}
	@Override
	public void mal() {
		System.out.println("팔 다리를 움직일 수 있다.");
	}
	@Override
	public String toString() {
		
		return "팔다리 움직이는 곰돌이 ";
	}
}
