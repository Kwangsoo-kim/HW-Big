package com.lec.ex02_store;

public class StoreMain {
	public static void main(String[] args) {
//		HeadQuarterStore h1 = new HeadQuarterStore("==����==");  �߻�Ŭ������ ��ü���� �Ұ�.
//		System.out.println(h1.getNa());
//		h1.kj();
//		h1.bj();
//		h1.bib();
//		h1.sd();
//		h1.gob();
		System.out.println("==================================");
		Store1 s1 = new Store1("==���ð�==");
		System.out.println(s1.getNa());
		s1.kj();
		s1.bj();
		s1.bib();
		s1.sd();
		s1.gob();
		System.out.println("==================================");
		Store2 s2 = new Store2("==���а�==");
		System.out.println(s2.getNa());
		s2.kj();
		s2.bj();
		s2.bib();
		s2.sd();
		s2.gob();
		System.out.println("==================================");
		Store3 s3 = new Store3("==���ǰ�==");
		System.out.println(s3.getNa());
		s3.kj();
		s3.bj();
		s3.bib();
		s3.sd();
		s3.gob();
		//HeadQuarterStore[] store = {h1,s1,s2,s3}; //�ڷ����� �޶�������, HeadQuarterStore�� �θ�Ŭ�����̱� ������ �����ϴ�. 
	}
}
