package com.lec.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex06_dateSimpleDAteFormat {
	public static void main(String[] args) {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YY-MM-dd(E) HH:MM");
		System.out.println(sdf.format(d));
	}
}
