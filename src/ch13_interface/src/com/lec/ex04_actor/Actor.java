package com.lec.ex04_actor;

public class Actor implements Ifirefighter, Ipolice, Ichef {
	private String na;

	public Actor(String na) {
		this.na = na;
	}

	@Override
	public void mp() {
		System.out.println(na+"��(��) ���ڸ� ���� �� �ִ�.");
	}

	@Override
	public void ms() {
		System.out.println(na+"��(��) ���İ�Ƽ�� ���� �� �ִ�.");
	}

	@Override
	public void ccc() {
		System.out.println(na+"��(��) ������ ���� �� �ִ�.");
	}

	@Override
	public void cci() {
		System.out.println(na+"��(��) ������ ã�� �� �ִ�.");
	}

	@Override
	public void offf() {
		System.out.println(na+"��(��) ���� �� �� �ִ�.");
	}

	@Override
	public void sm() {
		System.out.println(na+"��(��) ����� ���� �� �ִ�.");
	}

}
