package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Ex04_CalDateSimpleFormat {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		//2020�� 12�� 14�� 3�� 03��~
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� E���� a hh�� mm�� ss��");
//		/* yyyy(�⵵ 4�ڸ�) yy(�⵵ 2�ڸ�)
//		*  m (��)
//		*  d (��)
//		*  D ���� ���° ��
//		*  E ����
//		*  a ���� /����
//		*  h 24�ð�
//		*  m ��
//		*  s ��
//		*  S �и�����
//		*  w �̹��⵵�� ���° ��
//		*  W �̹� ���� ���° ��
//		  
		String today = sdf.format(cal.getTime());
		System.out.println(today);
		}
}
