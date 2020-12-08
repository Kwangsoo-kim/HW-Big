package com.lec.test;

public class Student {
	private static int count=0;
	private int no;
	private String na;
	private int k;
	private int e;
	private int m;
	private int tot;
	private int avg;
	
	public Student() {}
	public Student(String na, int k, int e, int m) {
		this.na=na;
		this.k=k;
		this.e=e;
		this.m=m;
		no=++count;
		tot = k+e+m;
		avg = tot/3;
	}
	public void print() {
		System.out.printf("%d   %s\t %d\t%d\t%d\t%d\t%d\n",no,na,k,e,m,tot,avg);
	}
	public void setNa(String na) {
		this.na=na;
	}
	public void setK(int k) {
		this.k=k;
	}
	public void setE(int e) {
		this.e=e;
	}
	public void setM(int m) {
		this.m=m;
	}
	public String getNa() {
		return na;
	}
	public int getK() {
		return k;
	}
	public int getE() {
		return e;
	}
	public int getM() {
		return m;
	}
	public void setNo(int no) {
		this.no=no;
	}
	public int getNo() {
		return no;
	}
	public void setTot() {
		this.tot=tot;
	}
	public int getTot() {
		return tot;
	}
	public void setAvg() {
		this.avg=avg;
	}
	public int getAvg() {
		return avg;
	}
}
