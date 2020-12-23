package com.lec.ex11_store;

public class Store2 extends HeadQuarterStore{
	public Store2(String na) {
		super(na);
	}
	//오버라이드(재정의) : 부모클래스의 메소드를 재정의
	//오버로드(중복정의) : 매개변수의 수나 타입으로 같은 이름의 함수를 중복 정의
	@Override
	public void bj() {
		System.out.println("부대찌개 5,000원");
	}
	@Override
	public void bib() {
		System.out.println("비빔밥 5,000원");
	}
	@Override
	public void gob() {
		System.out.println("공기밥 무료");
	}
}
