package com.lec.ex1_string;

public class Ex10_speedchk {
	public static void main(String[] args) {
		String str = "A";
		long start = System.currentTimeMillis();
		for(int i=0;i<200000; i++) {
			str=str.concat("a");
		}
		long end = System.currentTimeMillis();
		System.out.println("스트링 변경 시간 "+(end-start));
		
		StringBuffer strf = new StringBuffer("A");
		long startb = System.currentTimeMillis();
		for(int i =0;i<200000;i++) {
			strf.append("a");
		}
		long endb = System.currentTimeMillis();
		System.out.println("스트링 변경 시간 "+(endb-startb));
		StringBuilder strb = new StringBuilder("A");
		long startbd = System.currentTimeMillis();
		for(int i =0;i<200000;i++) {
			strb.append("a");
		}
		long endbd = System.currentTimeMillis();
		System.out.println("스트링 변경 시간 "+(endbd-startbd));
	}
}
