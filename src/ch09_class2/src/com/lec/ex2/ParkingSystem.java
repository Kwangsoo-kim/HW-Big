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
		System.out.println(cn+ "�� �������\n" + "�����ð� : "+ it+"��");
		
	}
	
	public int fee() {
		return fee;
	}
	public void inPs() {
		System.out.println(cn+ "�� �������\n" + "�����ð� : "+ it);
	}
	public void outPs() {
		 fee = (ot-it)*PiClass.HOURYRATE ;
		System.out.println(
				"cn"+ "�� �ȳ��Ͻ� ������\n"+"* �����ð� : "+ it+"��\n* �����ð� : "+ ot+ "��\n* ������� : "+ fee
				+"��");
	
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