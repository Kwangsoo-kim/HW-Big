package com.lec.ex09_book;

public class Book implements ILendable {
	private String bno; //책 청구번호
	private String bt;  //책 제목
	private String wt;  //저자
	private String bn;  //대출인 (입력)
	private String cod; //대출일 (입력)
	private byte st; //대출 상태
	public Book() {}
	public Book(String bno,String bt,String wt) {
		this.bno=bno;
		this.bt=bt;
		this.wt=wt;
	}
	@Override
	public void cOut(String bn, String cod) {
		if(st!=STATE_NOMAL) {
			System.out.println("대출 중. 대출불가.");
			return;
		}
		//대출처리로직	
		this.bn=bn;
		this.cod=cod;
		st=STATE_BORROWED;
		System.out.println("\""+bt+"\"도서가 대출되었습니다");
	}

	@Override
	public void cIn() {
		if(st!=STATE_BORROWED) {
			System.out.println("대출상태가 아님. 확인바람.");
			return;
		}
		//반납처리로직
		bn=null;
		cod=null;
		st=STATE_NOMAL;
		System.out.println("\""+bt+"\"도서가 반남되었습니다.");
	}

	@Override
	public void pstate() {
		if(st==STATE_NOMAL) {
			System.out.printf("%s, %s저 - 대출가능\n",bt,wt);
		}else if(st==STATE_BORROWED) {
			System.out.printf("%s, %s저 - 대출중\n",bt,wt);
		}else {
			System.out.println("오류");
		}
		//삼항연산자
//		String msg = bt+","+wt+" - ";
//		msg+= st==STATE_NOMAL? "대출가능":"대출중";
//		System.out.println(msg);
	}
	
}
