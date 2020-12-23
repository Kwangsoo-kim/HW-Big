package com.lec.ex02_store;

public class Store3 implements HeadQuarterStore {
	private String na;

	public Store3(String na) {
		this.na = na;
	}

	@Override
	public void kj() {
		System.out.println("±èÄ¡Âî°³ 6000¿ø");
	}

	@Override
	public void bj() {
		System.out.println("ºÎ´ëÂî°³ 7000¿ø");
	}

	@Override
	public void bib() {
		System.out.println("ºñº÷¹ä 7000¿ø");
	}

	@Override
	public void sd() {
		System.out.println("¼ø´ë±¹ 6,000¿ø");
	}

	@Override
	public void gob() {
		System.out.println("°ø±â¹ä 1,000¿ø");

	}

	public String getNa() {
		return na;
	}
}
