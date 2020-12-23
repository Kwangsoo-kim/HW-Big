package com.lec.ex09_person;
//Baby p = new Baby("홍길동","착하다")
public class Baby extends Person {
	public Baby() {
		System.out.println("매개 변수 없는 Baby 객체 생성");
	}
	public Baby(String na,String cha) {
		super(na,cha); // 부모단 생성자. 매개변수 있는놈으로 호출되게.   **항상 첫 명령어로 호출되어야함.
		System.out.println("매겨변수 있는 Baby 객체 생성");
	}
	public void Cry() {
		System.out.println("응애응애");
	}
	@Override
	public void intro() {
		System.out.println(getNa()+"은(는) 아기라서 엄마가 대신 소개할께");
		super.intro();
	}
}
