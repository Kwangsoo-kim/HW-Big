package com.lec.ex01_string;

import java.util.StringTokenizer;

public class Ex12_tokenArray {
	public static void main(String[] args) {
		// str�� tokenizer�Ͽ� na�迭��
		String str ="������ ���ػ� ������ ������ ������";
		String[] na;
		StringTokenizer tk1 = new StringTokenizer(str);
		tk1.countTokens();
		na = new String[tk1.countTokens()];
		int idx=0;
		while(tk1.hasMoreTokens()) {
			na[idx++] = tk1.nextToken();
		}
		System.out.println("����� �迭�� ������ Ȯ��");
		for(String n :na) {
			System.out.println(n);
		}
	}
}
