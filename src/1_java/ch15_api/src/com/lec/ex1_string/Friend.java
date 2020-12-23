package com.lec.ex1_string;

//이름,전화번호,생일
//print() : [이름]홍 [전화]8 [생일]12-12
public class Friend {
	private String na;
	private String tel;
	private String birth;

	public Friend(String na, String tel, String birth) {
		this.na = na;
		this.tel = tel;
		this.birth = birth;
	}

	public void print() {
		System.out.printf("[이름] %s [전화] %s [생일] %s", na, tel, birth);
	}

	public String toString() {
		return "[이름] " + na + "\t[전화] " + tel + "\t[생일] " + birth;
	}

	public String getNa() {
		return na;
	}

	public String getTel() {
		return tel;
	}

	public String getBirth() {
		return birth;
	}

}
