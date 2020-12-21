//201218 kks io_example
package com.lec.ex2_dataInputStreamOutputStream;

public class Product {
	private String na;
	private int pr;
	private int ps;

	public Product(String na, int pr, int ps) {
		this.na = na;
		this.pr = pr;
		this.ps = ps;
	}

	@Override
	public String toString() {
		return na + "\t" + pr + "\t" + ps;
	}

}
