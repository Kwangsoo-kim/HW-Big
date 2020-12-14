package com.lec.ex2_date;

import java.util.Date;

public class Ex03_Date {
	public static void main(String[] args) {
		Date d = new Date(); // 시스템으로 부터 현재의 시간을 가져옴
		System.out.println(d);
		int year = d.getYear() + 1900;
		int month = d.getMonth() + 1;
		int day = d.getDate();
		int hour = d.getHours();
		int minute = d.getMinutes();
		int second = d.getSeconds();
		System.out.printf("%d년 %d월 %d일 %d시 %d분 %d초 \n",year,month,day,hour,minute,second);
		System.out.printf("%tY년 %tm월 %td일 %tH시 %tM분 %tS초\n",d,d,d,d,d,d);
		System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$tH시 %1$tM분 %1$tS초\n",d);
		
	}
}
