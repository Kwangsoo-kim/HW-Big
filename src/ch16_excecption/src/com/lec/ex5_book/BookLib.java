//201216 kks example
package com.lec.ex5_book;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class BookLib implements ILendable {
	private String bno;
	private String btt;
	private String wit;
	private String brr;
	private Date cod;
	private byte state;
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY�� MM�� dd��(E)");
	public BookLib(){}
	public BookLib(String bno, String btt, String wit) {
		this.bno = bno;
		this.btt = btt;
		this.wit = wit;
		state=STATE_NORMAL;
	}
	public void prints() {
		if(state==STATE_BORROWED) {
			System.out.println( "\""+btt+"\""+"("+bno+")"+""+wit+"��"+" ������");
		}else if(state==STATE_NORMAL) {
			System.out.println( "\""+btt+"\""+"("+bno+")"+""+wit+"��"+" ���Ⱑ��");
		}
	}

	@Override
	public void cOt(String brr) throws Exception {
		if(state!=STATE_NORMAL) {
			throw new Exception("����� �����Դϴ�. ���� �Ұ��� �մϴ�.");
		}
		this.brr=brr;
		this.cod=new Date();
		state=STATE_BORROWED;
		System.out.println(btt+"�� ����Ǿ����ϴ�.\n"+"[������] "+brr+"\n"+"[������] "+sdf.format(cod));
	}
	@Override
	public void cIn() throws Exception {
		if(state!=STATE_BORROWED) {
			throw new Exception("����� ������ �ƴմϴ�. �ݳ� �Ұ��� �մϴ�.");
		}
		Date cin =new Date();
		long diff = cin.getTime()-cod.getTime();
		long day = diff/(1000*60*60*24);
		if(day>14) {
			day=day-14;
			System.out.println("��ü�� ���� 100�� �ΰ��մϴ�.");
			System.out.println("���ž��� ��ü���"+(day*100)+"��");
			System.out.println("��ü�Ḧ ���� �ϼ̳���?(Y/N)");
			String ok =sc.next();
			if(ok.equalsIgnoreCase("y")) {
				System.out.println("��ü�� ���� Ȯ�εǾ����ϴ�.");
			}else if(ok.equalsIgnoreCase("n")) {
				System.out.println("��ü�Ḧ �����ϼ���");
				return;
			}
		}
		brr=null;
		cod=null;
		state=STATE_NORMAL;
		System.out.println("�ݳ��Ǿ����ϴ�.");
	}
	@Override
	public String toString() {
		
		if(state==STATE_BORROWED) {
			System.out.println( "\""+btt+"\""+"("+bno+")"+""+wit+"��"+" ������");
		}else if(state==STATE_NORMAL) {
			System.out.println( "\""+btt+"\""+"("+bno+")"+""+wit+"��"+" ���Ⱑ��");
		}
		return"";
	}
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		this.bno = bno;
	}
	public String getBtt() {
		return btt;
	}
	public void setBtt(String btt) {
		this.btt = btt;
	}
	public String getWit() {
		return wit;
	}
	public void setWit(String wit) {
		this.wit = wit;
	}
	public String getBrr() {
		return brr;
	}
	public void setBrr(String brr) {
		this.brr = brr;
	}
	public Date getCod() {
		return cod;
	}
	public void setCod(Date cod) {
		this.cod = cod;
	}
	public byte getState() {
		return state;
	}
	public void setState(byte state) {
		this.state = state;
	}
}
