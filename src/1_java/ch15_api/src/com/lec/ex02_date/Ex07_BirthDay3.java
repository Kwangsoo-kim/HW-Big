package com.lec.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.lec.ex01_string.Friend;

public class Ex07_BirthDay3 {
	public static void main(String[] args) {
		Friend[] fs = { new Friend("ȫ�浿","010-2222-3333", "12-14"),
				new Friend("��浿","010-4444-4444", "03-14"),
				new Friend("���浿","010-1234-1234", "12-14")
		};
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String td = sdf.format(now);
		System.out.println("������"+td);
		boolean searchOk = false;
		System.out.println("���� ������ ����� ����� ������ �����ϴ�.");
		for(int i=0;i<fs.length;i++) {
			String bd = fs[i].getBirth();
			if(bd.equals(td)) {
				System.out.println(fs[i]);
				searchOk =true;
			}
		}
		if(!searchOk) {
			System.out.println("������ ������ ����� �����ϴ�.");
		}
	}
}
