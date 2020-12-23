package com.lec.condition;

public class Ex04_switch {
	public static void main(String[] args) {
		int n1 = 2;
		//스위치는 if 와 마찬가지로 블럭으로 감싸야하고, 변수느 정수와 string만 올 수 있다
		switch(n1) {
		case 1:
			System.out.println("주사위 1"); break;
		case 2:
			System.out.println("주사위 2"); break;
		case 3:
			System.out.println("주사위 3"); break;
		default:
			System.out.println("그 외"); break; //break는 알맞는 조건이 나오면 그 조건만 실행하고 프로그램을 끝낸다. 꼭 넣자.
		}
	}
}
