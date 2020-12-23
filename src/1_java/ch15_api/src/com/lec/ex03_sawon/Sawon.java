package com.lec.ex03_sawon;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sawon {
	private String num;
	private String name;
	private PartType part;
//	private String part;
	private Date enterDate;
	SimpleDateFormat sdf = new SimpleDateFormat("YY-MM-dd");
	public Sawon(String num, String name, PartType part, int y, int m, int d) {
		this.num = num;
		this.name = name;
		this.part = part;
		enterDate = new Date(new GregorianCalendar(y,m-1,d).getTimeInMillis());
	}
	public Sawon(String num, String name, PartType part) {
		this.num = num;
		this.name = name;
		this.part = part;
		enterDate =new Date();
	}
	public String toString() {
		return "[사번] : "+num+"\t[이름] : "+name+"\t[입사일] : "+sdf.format(enterDate);
			
	}
	public String getNum() {
		return num;
	}
	public String getName() {
		return name;
	}
	public PartType getPart() {
		return part;
	}
	public Date getEnterDate() {
		return enterDate;
	}
	public SimpleDateFormat getSdf() {
		return sdf;
	}
}
