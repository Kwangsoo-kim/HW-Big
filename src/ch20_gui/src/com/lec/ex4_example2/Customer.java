package com.lec.ex4_example2;

public class Customer {
	private String tel;
	private String name;
	private int point;
	public Customer(String tel, String name, int point) {
		this.tel = tel;
		this.name = name;
		this.point = point;
	}
	public Customer(String tel, String name) {
		this.tel = tel;
		this.name = name;
		this.point = 1000;
	}
	@Override
	public String toString() {
		return "[이름] : "+name+"\t[폰번호] : "+tel+"\t[포인트] : "+point+"\r\n";
	}
	public String getTel() {
		return tel;
	}
	public String getName() {
		return name;
	}
	public int getPoint() {
		return point;
	}
}
