package com.lec.ex09_book;

public class Test {
	public static void main(String[] args) {
		Book b1 = new Book("890a","�ڹ�","ȫ�浿");
		Book b2 = new Book("8390a","�ϵ�","ȫ���");
		b1.cIn();
		b1.cOut("�ű浿", "202001");
		b1.cOut("�赿��", "202031");
		b1.pstate();
		b2.pstate();
	}
}
