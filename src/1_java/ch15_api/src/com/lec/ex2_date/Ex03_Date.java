package com.lec.ex2_date;

import java.util.Date;

public class Ex03_Date {
	public static void main(String[] args) {
		Date d = new Date(); // �ý������� ���� ������ �ð��� ������
		System.out.println(d);
		int year = d.getYear() + 1900;
		int month = d.getMonth() + 1;
		int day = d.getDate();
		int hour = d.getHours();
		int minute = d.getMinutes();
		int second = d.getSeconds();
		System.out.printf("%d�� %d�� %d�� %d�� %d�� %d�� \n",year,month,day,hour,minute,second);
		System.out.printf("%tY�� %tm�� %td�� %tH�� %tM�� %tS��\n",d,d,d,d,d,d);
		System.out.printf("%1$tY�� %1$tm�� %1$td�� %1$tH�� %1$tM�� %1$tS��\n",d);
		
	}
}
