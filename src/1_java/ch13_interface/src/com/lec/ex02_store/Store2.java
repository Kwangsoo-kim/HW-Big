package com.lec.ex02_store;

public class Store2 implements HeadQuarterStore {
	private String na;

	public Store2(String na) {
		this.na = na;
	}

	// �������̵�(������) : �θ�Ŭ������ �޼ҵ带 ������
	// �����ε�(�ߺ�����) : �Ű������� ���� Ÿ������ ���� �̸��� �Լ��� �ߺ� ����
	@Override
	public void kj() {
		System.out.println("��ġ� 5,000��");

	}

	@Override
	public void bj() {
		System.out.println("�δ�� 5,000��");
	}

	@Override
	public void bib() {
		System.out.println("����� 5,000��");
	}

	@Override
	public void sd() {
		System.out.println("���뱹 5,000d��");

	}

	@Override
	public void gob() {
		System.out.println("����� ����");
	}

	public String getNa() {
		return na;
	}

}
