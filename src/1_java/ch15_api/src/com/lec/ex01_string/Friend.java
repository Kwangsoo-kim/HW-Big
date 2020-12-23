package com.lec.ex01_string;

//�̸�,��ȭ��ȣ,����
//print() : [�̸�]ȫ [��ȭ]8 [����]12-12
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
		System.out.printf("[�̸�] %s [��ȭ] %s [����] %s", na, tel, birth);
	}

	public String toString() {
		return "[�̸�] " + na + "\t[��ȭ] " + tel + "\t[����] " + birth;
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
