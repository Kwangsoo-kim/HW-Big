package com.lec.ex01_store;

//추상클래스 : 추상메소드가 1개 이상 있는 클래스
//추상클래스는 객체생성 불가.
public abstract class HeadQuarterStore {
	private String na;

	public HeadQuarterStore(String na) {
		this.na = na;
	}

	public abstract void kj(); // 추상 메소드. 꼭 오버라이드 하시오!

	public abstract void bj();

	public abstract void bib();

	public abstract void sd();

	public abstract void gob();

	public String getNa() {
		return na;
	}

	public void setNa(String na) {
		this.na = na;
	}
}
