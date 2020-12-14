package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.lec.ex1_string.Friend;

public class Ex07_BirthDay3 {
	public static void main(String[] args) {
		Friend[] fs = { new Friend("홍길동","010-2222-3333", "12-14"),
				new Friend("삼길동","010-4444-4444", "03-14"),
				new Friend("오길동","010-1234-1234", "12-14")
		};
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String td = sdf.format(now);
		System.out.println("오늘은"+td);
		boolean searchOk = false;
		System.out.println("오늘 생일인 사람의 목록은 다음과 같습니다.");
		for(int i=0;i<fs.length;i++) {
			String bd = fs[i].getBirth();
			if(bd.equals(td)) {
				System.out.println(fs[i]);
				searchOk =true;
			}
		}
		if(!searchOk) {
			System.out.println("오늘이 생일인 사람은 없습니다.");
		}
	}
}
