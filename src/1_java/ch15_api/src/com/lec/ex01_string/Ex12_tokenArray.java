package com.lec.ex01_string;

import java.util.StringTokenizer;

public class Ex12_tokenArray {
	public static void main(String[] args) {
		// str을 tokenizer하여 na배열로
		String str ="정해인 유준상 강동원 김윤석 하정우";
		String[] na;
		StringTokenizer tk1 = new StringTokenizer(str);
		tk1.countTokens();
		na = new String[tk1.countTokens()];
		int idx=0;
		while(tk1.hasMoreTokens()) {
			na[idx++] = tk1.nextToken();
		}
		System.out.println("제대로 배열에 들어갔는지 확인");
		for(String n :na) {
			System.out.println(n);
		}
	}
}
