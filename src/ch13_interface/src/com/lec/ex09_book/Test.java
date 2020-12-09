package com.lec.ex09_book;

public class Test {
	public static void main(String[] args) {
		Book b1 = new Book("890a","ÀÚ¹Ù","È«±æµ¿");
		Book b2 = new Book("8390a","ÇÏµÓ","È«±æ¼ø");
		b1.cIn();
		b1.cOut("½Å±æµ¿", "202001");
		b1.cOut("±èµ¿±æ", "202031");
		b1.pstate();
		b2.pstate();
	}
}
