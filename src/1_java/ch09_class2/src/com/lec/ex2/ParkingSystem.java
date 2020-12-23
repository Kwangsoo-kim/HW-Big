package com.lec.ex2;

import com.lec.cons.PiClass;

public class ParkingSystem {
	private String cn;
	private int it;
	private int ot;
	private int fee;
	//private final int HOURLYRATE = 2000;
	
	public ParkingSystem() {}
	public ParkingSystem(String cn, int it) {
		this.cn=cn;
		this.it=it;
		System.out.println(cn+ "님 어서오세요\n" + "입차시간 : "+ it+"시");
		
	}
	
	public int fee() {
		return fee;
	}
	public void inPs() {
		System.out.println(cn+ "님 어서오세요\n" + "입차시간 : "+ it);
	}
	public void outPs() {
		 fee = (ot-it)*PiClass.HOURYRATE ;
		System.out.println(
				"cn"+ "님 안녕하시 가세요\n"+"* 입차시간 : "+ it+"시\n* 출차시간 : "+ ot+ "시\n* 주차요금 : "+ fee
				+"원");
	
	}
	public void setCn(String cn) {
		this.cn=cn;
	}
	public void setIt(int it) {
		this.it=it;
	}
	public void setOt(int ot) {
		this.ot=ot;
	}
	public void setF(int fee) {
		this.fee=fee;
	}
	public String getCn() {
		return cn;
	}
	public int getIt() {
		return it;
	}
	public int getOt() {
		return ot;
	}
	public int getF() {
		return fee;
	}
	
	
}