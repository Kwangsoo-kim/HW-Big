package com.lec.ex5_momchild;

public class ChildTest {
	public static void main(String[] args) {
		Child ch1 = new Child("첫째 돌만이");
		Child ch2 = new Child("둘째 갑돌이");
		Child ch3 = new Child("셋째 돌순이");
		ch1.takeMoney(1000);
		ch1.takeMoney(1000);
		ch2.takeMoney(1000);
		ch3.takeMoney(1000);
		System.out.println("첫 째 엄마 지갑"+ ch1.momPouch.money);
		System.out.println("둘 째 엄마 지갑"+ ch2.momPouch.money);
		System.out.println("셋 째 엄마 지갑"+ ch3.momPouch.money);
		System.out.println("static 엄마 지갑은 : "+ Child.momPouch.money);
	}
}
