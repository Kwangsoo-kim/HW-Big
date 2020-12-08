package com.lec.ex01_store;

public class StoreMain2 {
	public static void main(String[] args) {
		HeadQuarterStore[] st = {//new HeadQuarterStore("본사"),
								 new Store1("주택가 1호점"),
								 new Store2("대학가 2호점"),
								 new Store3("증권가 3호점")
		};
		for(HeadQuarterStore s : st) {
			System.out.println(s.getNa());
			s.kj();
			s.bj();
			s.bib();
			s.sd();
			s.gob();
		}
		System.out.println("===============================");
		for(int i=0; i<st.length;i++) {
			System.out.println(st[i].getNa());
			st[i].kj();
			st[i].bj();
			st[i].bib();
			st[i].sd();
			st[i].gob();
		}
		
	}
}
