package com.lec.ex11_store;

public class Store2 extends HeadQuarterStore{
	public Store2(String na) {
		super(na);
	}
	//�������̵�(������) : �θ�Ŭ������ �޼ҵ带 ������
	//�����ε�(�ߺ�����) : �Ű������� ���� Ÿ������ ���� �̸��� �Լ��� �ߺ� ����
	@Override
	public void bj() {
		System.out.println("�δ�� 5,000��");
	}
	@Override
	public void bib() {
		System.out.println("����� 5,000��");
	}
	@Override
	public void gob() {
		System.out.println("����� ����");
	}
}
