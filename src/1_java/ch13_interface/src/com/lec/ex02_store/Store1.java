package com.lec.ex02_store;

public class Store1 implements HeadQuarterStore {
	private String na;

	public Store1(String na) {
		this.na = na;
	}

	@Override
	public void kj() {
		System.out.println("��ġ� 4,500��");
	}

	@Override
	public void bj() {
		System.out.println("�δ�� 5,000��");
	}

	@Override
	public void bib() {
		System.out.println("����� 6,000��");

	}

	@Override
	public void sd() {
		System.out.println("���Ⱦ�~");
	}

	@Override
	public void gob() {
		System.out.println("����� 1,000��");

	}

	public String getNa() {
		return na;
	}

}
