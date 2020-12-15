package com.lec.ex02_date;

import java.util.Date;
import java.util.GregorianCalendar;
//날자 계산은 밀리세컨으로 한다.
public class Ex08_dateCal {
	public static void main(String[] args) {
		GregorianCalendar now = new GregorianCalendar(); //지금
		long nowMillis = now.getTimeInMillis(); 
		GregorianCalendar thatTime =  new GregorianCalendar(2020,10,30,9,30,0);
		long thatmillis = thatTime.getTimeInMillis();
		long mi = nowMillis - thatmillis;
		int day = (int)(mi)/(1000*60*60*24);
		System.out.println(mi);
		System.out.println(mi/1000);
		System.out.println("개강한 이후 "+day+"일 지남");
		System.out.println("=================================================");
		System.out.println("=================================================");
		System.out.println("=================================================");
		System.out.println("=================================================");
		Date thatDay= new Date(new GregorianCalendar(2020,10,30,9,30,0).getTimeInMillis());
		System.out.println(thatDay);
		
		
	}
}
