package com.lec.ex02_store;

public class Store3 implements HeadQuarterStore {
	private String na;

	public Store3(String na) {
		this.na = na;
	}

	@Override
	public void kj() {
		System.out.println("��ġ� 6000��");
	}

	@Override
	public void bj() {
		System.out.println("�δ�� 7000��");
	}

	@Override
	public void bib() {
		System.out.println("����� 7000��");
	}

	@Override
	public void sd() {
		System.out.println("���뱹 6,000��");
	}

	@Override
	public void gob() {
		System.out.println("����� 1,000��");

	}

	public String getNa() {
		return na;
	}
}
