package com.lec.loop;
//Ȧ���� ���ϴ¹�
public class Q2_for {
	public static void main(String[] args) {
		int hab = 0;
//		for(int i=1; i<11; i+=2) {
//			hab=hab+i;
//		}
//		System.out.println(hab);
		
		for(int i = 1; i<11; i++) {
			if(i%2 == 1) {
				hab= hab+i;
			}
		}
		System.out.println(hab);
	}
}
