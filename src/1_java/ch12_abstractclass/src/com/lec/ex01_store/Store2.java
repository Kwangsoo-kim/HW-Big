package com.lec.ex01_store;

public class Store2 extends HeadQuarterStore {
	public Store2(String na) {
		super(na);
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

}
