package com.lec.ex02_date;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Ex05_gcSimpleDateFormat {
	public static void main(String[] args) {
		GregorianCalendar gcal = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("M��d�� a h��  m��");
		System.out.println(sdf.format(gcal.getTime()));
	}
}
