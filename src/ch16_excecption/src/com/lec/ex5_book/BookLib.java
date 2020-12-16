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
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY년 MM월 dd일(E)");
	public BookLib(){}
	public BookLib(String bno, String btt, String wit) {
		this.bno = bno;
		this.btt = btt;
		this.wit = wit;
		state=STATE_NORMAL;
	}
	public void prints() {
		if(state==STATE_BORROWED) {
			System.out.println( "\""+btt+"\""+"("+bno+")"+""+wit+"저"+" 대출중");
		}else if(state==STATE_NORMAL) {
			System.out.println( "\""+btt+"\""+"("+bno+")"+""+wit+"저"+" 대출가능");
		}
	}

	@Override
	public void cOt(String brr) throws Exception {
		if(state!=STATE_NORMAL) {
			throw new Exception("대출된 도서입니다. 대출 불가능 합니다.");
		}
		this.brr=brr;
		this.cod=new Date();
		state=STATE_BORROWED;
		System.out.println(btt+"가 대출되었습니다.\n"+"[대출인] "+brr+"\n"+"[대출일] "+sdf.format(cod));
	}
	@Override
	public void cIn() throws Exception {
		if(state!=STATE_BORROWED) {
			throw new Exception("대출된 도서가 아닙니다. 반납 불가능 합니다.");
		}
		Date cin =new Date();
		long diff = cin.getTime()-cod.getTime();
		long day = diff/(1000*60*60*24);
		if(day>14) {
			day=day-14;
			System.out.println("연체료 일일 100원 부과합니다.");
			System.out.println("내셔야할 연체료는"+(day*100)+"원");
			System.out.println("연체료를 지불 하셨나요?(Y/N)");
			String ok =sc.next();
			if(ok.equalsIgnoreCase("y")) {
				System.out.println("연체료 지불 확인되었습니다.");
			}else if(ok.equalsIgnoreCase("n")) {
				System.out.println("연체료를 지불하세요");
				return;
			}
		}
		brr=null;
		cod=null;
		state=STATE_NORMAL;
		System.out.println("반납되었습니다.");
	}
	@Override
	public String toString() {
		
		if(state==STATE_BORROWED) {
			System.out.println( "\""+btt+"\""+"("+bno+")"+""+wit+"저"+" 대출중");
		}else if(state==STATE_NORMAL) {
			System.out.println( "\""+btt+"\""+"("+bno+")"+""+wit+"저"+" 대출가능");
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
