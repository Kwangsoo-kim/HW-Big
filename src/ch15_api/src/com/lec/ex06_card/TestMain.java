//20.12.15 kks equals override
package com.lec.ex06_card;

public class TestMain {
	public static void main(String[] args) {
		Card[] c = {new Card("��", 2),
				new Card("��", 3),
				new Card("��", 7),
				new Card("��",1)
		};
		Card yours = new Card("��",1);
		System.out.println("��� ī�� : "+yours);
		for(int i=0;i<c.length;i++) {
			System.out.print(c[i]);
			if(yours.equals(c[i])) {
				System.out.println(" - ��� ī��� ��ġ�մϴ�.");
			}else {
				System.out.println(" - ��� ī��� ��ġ���� �ʽ��ϴ�.");
			}
		}
	}
}
