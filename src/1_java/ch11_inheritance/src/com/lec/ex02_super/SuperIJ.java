package com.lec.ex02_super;

public class SuperIJ {
	private int i;
	private int j;
	public SuperIJ() { //�θ�Ŭ������ ����Ҷ� �Ű��������� �����ڰ� �ʿ��ϴ�. ���ٸ� �ٸ� ���밡 �ʿ�.
		System.out.println("�Ű����� ���� ��");
	}
	public SuperIJ(int i, int j) {
		this.i = i;
		this.j = j;
		System.out.println("�Ű����� �ִ°�");
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	
}
