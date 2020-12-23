package com.lec.ex02_date;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ex09_DayCal {
	public static void main(String[] args) {
		Date cod = new Date(new GregorianCalendar(2020,10,14).getTimeInMillis());
		Date now = new Date();
		//now.getTime(); : now 시점의 millisec
		long diff = now.getTime() - cod.getTime();
		long day =diff/(1000*60*60*24); // cod부터 now까지 몇일 지났는지 계산.
		if(day>14) {
			day = day-14;
			System.out.println("연체료"+(day*100)+"원을 받으셨나요(Y/N)?");
			Scanner sc = new Scanner(System.in);
			String ok = sc.next();
			if(ok.equalsIgnoreCase("Y")) {
				System.out.println("반납되었습니다.");
			}else if(ok.equalsIgnoreCase("N")) {
				System.out.println("연체료를 지불하시오.");
				return;
			}
		}else {
			System.out.println("반납되었습니다.");
		}
		
	}
}
