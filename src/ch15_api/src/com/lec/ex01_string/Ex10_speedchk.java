package com.lec.ex01_string;

public class Ex10_speedchk {
	public static void main(String[] args) {
		String str = "A";
		long start = System.currentTimeMillis();
		for(int i=0;i<200000; i++) {
			str=str.concat("a");
		}
		long end = System.currentTimeMillis();
		System.out.println("��Ʈ�� ���� �ð� "+(end-start));
		
		StringBuffer strf = new StringBuffer("A");
		long startb = System.currentTimeMillis();
		for(int i =0;i<200000;i++) {
			strf.append("a");
		}
		long endb = System.currentTimeMillis();
		System.out.println("��Ʈ�� ���� �ð� "+(endb-startb));
		StringBuilder strb = new StringBuilder("A");
		long startbd = System.currentTimeMillis();
		for(int i =0;i<200000;i++) {
			strb.append("a");
		}
		long endbd = System.currentTimeMillis();
		System.out.println("��Ʈ�� ���� �ð� "+(endbd-startbd));
	}
}
