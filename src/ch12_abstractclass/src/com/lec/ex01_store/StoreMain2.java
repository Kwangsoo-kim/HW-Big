package com.lec.ex01_store;

public class StoreMain2 {
	public static void main(String[] args) {
		HeadQuarterStore[] st = {//new HeadQuarterStore("����"),
								 new Store1("���ð� 1ȣ��"),
								 new Store2("���а� 2ȣ��"),
								 new Store3("���ǰ� 3ȣ��")
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
