package com.lec.ex11_store;

public class HeadQuarterStore {
	private String na;

	public HeadQuarterStore(String na) {
		this.na = na;
	}

	public void kj() {
		System.out.println("±èÄ¡Âî°³ 5,000¿ø");
	}

	public void bj() {
		System.out.println("ºÎ´ëÂî°³ 5,000¿ø");
	}

	public void bib() {
		System.out.println("ºñºö¹ä 5,000¿ø");
	}

	public void sd() {
		System.out.println("¼ø´ë±¹ 5,000¿ø");
	}

	public void gob() {
		System.out.println(" °ø±â¹ä 1,000¿ø");
	}

	public String getNa() {
		return na;
	}
	public void setNa(String na) {
		this.na=na;
	}
}
