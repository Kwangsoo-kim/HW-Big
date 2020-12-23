//20.12.15 kks example
package com.lec.ex07_market;

public class Goods {
	private String gCode;
	private String gName;
	private int price;
	private int sNum;
	public Goods(String gCode, String gName, int price, int sNum) {
		this.gCode=gCode;
		this.gName=gName;
		this.price=price;
		this.sNum=sNum;
	}
	@Override
	public String toString() {
		return gName+"("+gCode+")"+"의 가격 : "+price+", 재고수량 : "+sNum;
	}
	public String getgCode() {
		return gCode;
	}
	public String getgName() {
		return gName;
	}
	public int getPrice() {
		return price;
	}
	public int getsNum() {
		return sNum;
	}
	
}
