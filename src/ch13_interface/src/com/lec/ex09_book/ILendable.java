package com.lec.ex09_book;

public interface ILendable {
	public byte STATE_BORROWED = 1; // 대출중
	public byte STATE_NOMAL = 0; // 대출가능
	public void cOut(String bn,String cd); //대출로직
	public void cIn(); //반납로직
	public void pstate(); // 책 상태. "책이름" , "저자", "대출가능유무"
}
