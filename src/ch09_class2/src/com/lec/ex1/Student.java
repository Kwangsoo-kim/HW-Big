package com.lec.ex1;

public class Student {
	private String n;
	private int k;
	private int e;
	private int m;
	private int tot;
	private double avg;

	public Student() {
	}

	public Student(String n, int k, int e, int m) {
		this.n = n;
		this.k = k;
		this.e = e;
		this.m = m;
		tot = k + e + m;
		avg = tot / 3.0;
	}

	public int tot() {
		tot = k + e + m;
		return tot;
	}

	public double avg() {
		avg = (k + e + m) / 3.0;
		return avg;
	}

	public void print() {
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f\n", n, k, e, m, tot, avg);
	}

	public void setN(String n) {
		this.n = n;
	}

	public void setK(int k) {
		this.k = k;
	}

	public void setE(int e) {
		this.e = e;
	}

	public void setM(int m) {
		this.m = m;
	}

	public String getN() {
		return n;
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

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

}
