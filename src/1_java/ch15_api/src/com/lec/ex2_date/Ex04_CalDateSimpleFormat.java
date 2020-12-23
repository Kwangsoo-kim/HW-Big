package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Ex04_CalDateSimpleFormat {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		//2020년 12월 14일 3시 03분~
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a hh시 mm분 ss초");
//		/* yyyy(년도 4자리) yy(년도 2자리)
//		*  m (월)
//		*  d (일)
//		*  D 올해 몇번째 날
//		*  E 요일
//		*  a 오전 /오후
//		*  h 24시간
//		*  m 분
//		*  s 초
//		*  S 밀리세컨
//		*  w 이번년도의 몇번째 주
//		*  W 이번 월에 면번째 주
//		  
		String today = sdf.format(cal.getTime());
		System.out.println(today);
		}
}
