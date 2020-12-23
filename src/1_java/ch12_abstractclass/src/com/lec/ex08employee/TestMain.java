package com.lec.ex08employee;

public class TestMain {
	public static void main(String[] args) {
		Employee s1 = new SalaryEmployee("ȫ�浿", 28000000);
		Employee h1 = new HourlyEmployee("�ű浿", 100, 8500);
		Employee s2 = new SalaryEmployee("ȫ�浿", 70000000);
		s1.payinfo();
		h1.payinfo();
		s2.payinfo();
		
	}
}
