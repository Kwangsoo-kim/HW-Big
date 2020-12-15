package com.lec.ex02_date;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ex09_DayCal {
	public static void main(String[] args) {
		Date cod = new Date(new GregorianCalendar(2020,10,14).getTimeInMillis());
		Date now = new Date();
		//now.getTime(); : now ������ millisec
		long diff = now.getTime() - cod.getTime();
		long day =diff/(1000*60*60*24); // cod���� now���� ���� �������� ���.
		if(day>14) {
			day = day-14;
			System.out.println("��ü��"+(day*100)+"���� �����̳���(Y/N)?");
			Scanner sc = new Scanner(System.in);
			String ok = sc.next();
			if(ok.equalsIgnoreCase("Y")) {
				System.out.println("�ݳ��Ǿ����ϴ�.");
			}else if(ok.equalsIgnoreCase("N")) {
				System.out.println("��ü�Ḧ �����Ͻÿ�.");
				return;
			}
		}else {
			System.out.println("�ݳ��Ǿ����ϴ�.");
		}
		
	}
}
