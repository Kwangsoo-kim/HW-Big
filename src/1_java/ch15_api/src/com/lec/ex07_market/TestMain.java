//20.12.15 kks example
package com.lec.ex07_market;

public class TestMain {
	public static void main(String[] args) {
		Goods s1 = new Goods("a001","�����",1100,10);
		Goods s2 = new Goods("a002","����Ĩ",2000,20);
		Goods s3 = new Goods("a003","���ִ� ����",850,35);
		Customer c1 = new Customer("010-9999-9999","ȫ�浿");
		Customer c2 = new Customer("010-8888-8888","�踶��");
		Customer c3 = new Customer("010-8888-8888","�̵���");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c2.equals(c3));
	}
}