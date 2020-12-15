package com.lec.ex02_date;

import java.util.Calendar;

import com.lec.ex01_string.Friend;

public class Ex07_birthDay2 {
	public static void main(String[] args) {
		Friend[] fs = {new Friend("ȫ�浿","010-2345-2345","12-14"),
					new Friend("ȫ�繫","010-9999-9999", "01-01"),
					new Friend("�ű浿","010-1234-1234","12-14")};
		Calendar now = Calendar.getInstance();
		int m = now.get(Calendar.MONTH)+1;
		int d = now.get(Calendar.DAY_OF_MONTH);
		String ms = (m<10)? "0"+m : ""+m;
		String ds = (d<10)? "0"+d : ""+d;
		String td = ms+"-"+ds;
		System.out.println("������"+td);
		boolean searchOk = false;
		System.out.println("���� ������ ����� ����� ������ �����ϴ�.");
		for(int i=0;i<fs.length;i++) {
			String bd = fs[i].getBirth();
			if(bd.equals(td)) {
				System.out.println(fs[i]);
				searchOk = true;
			}
		}
		if(!searchOk) {
			System.out.println("������ ������ ����� �����ϴ�");
		}
	}
}
