package com.lec.ex04_actor;

public class Actor implements Ifirefighter, Ipolice, Ichef {
	private String na;

	public Actor(String na) {
		this.na = na;
	}

	@Override
	public void mp() {
		System.out.println(na+"은(는) 피자를 만들 수 있다.");
	}

	@Override
	public void ms() {
		System.out.println(na+"은(는) 스파게티를 만들 수 있다.");
	}

	@Override
	public void ccc() {
		System.out.println(na+"은(는) 범인을 잡을 수 있다.");
	}

	@Override
	public void cci() {
		System.out.println(na+"은(는) 물건을 찾을 수 있다.");
	}

	@Override
	public void offf() {
		System.out.println(na+"은(는) 불을 끌 수 있다.");
	}

	@Override
	public void sm() {
		System.out.println(na+"은(는) 사람을 구할 수 있다.");
	}

}
