package com.lec.ex02_store;

public class Store1 implements HeadQuarterStore {
	private String na;

	public Store1(String na) {
		this.na = na;
	}

	@Override
	public void kj() {
		System.out.println("±èÄ¡Âî°³ 4,500¿ø");
	}

	@Override
	public void bj() {
		System.out.println("ºÎ´ëÂî°³ 5,000¿ø");
	}

	@Override
	public void bib() {
		System.out.println("ºñºö¹ä 6,000¿ø");

	}

	@Override
	public void sd() {
		System.out.println("¾ÈÆÈ¾Æ~");
	}

	@Override
	public void gob() {
		System.out.println("°ø±â¹ä 1,000¿ø");

	}

	public String getNa() {
		return na;
	}

}
