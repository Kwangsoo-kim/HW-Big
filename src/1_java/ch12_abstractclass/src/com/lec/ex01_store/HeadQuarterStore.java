package com.lec.ex01_store;

//�߻�Ŭ���� : �߻�޼ҵ尡 1�� �̻� �ִ� Ŭ����
//�߻�Ŭ������ ��ü���� �Ұ�.
public abstract class HeadQuarterStore {
	private String na;

	public HeadQuarterStore(String na) {
		this.na = na;
	}

	public abstract void kj(); // �߻� �޼ҵ�. �� �������̵� �Ͻÿ�!

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
