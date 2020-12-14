package com.lec.ex2_date;

import java.util.Calendar;

import com.lec.ex1_string.Friend;

public class Ex07_birthDay2 {
	public static void main(String[] args) {
		Friend[] fs = {new Friend("홍길동","010-2345-2345","12-14"),
					new Friend("홍당무","010-9999-9999", "01-01"),
					new Friend("신길동","010-1234-1234","12-14")};
		Calendar now = Calendar.getInstance();
		int m = now.get(Calendar.MONTH)+1;
		int d = now.get(Calendar.DAY_OF_MONTH);
		String ms = (m<10)? "0"+m : ""+m;
		String ds = (d<10)? "0"+d : ""+d;
		String td = ms+"-"+ds;
		System.out.println("오늘은"+td);
		boolean searchOk = false;
		System.out.println("오늘 생일인 사람의 목록은 다음과 같습니다.");
		for(int i=0;i<fs.length;i++) {
			String bd = fs[i].getBirth();
			if(bd.equals(td)) {
				System.out.println(fs[i]);
				searchOk = true;
			}
		}
		if(!searchOk) {
			System.out.println("오늘이 생일인 사람은 없습니다");
		}
	}
}
