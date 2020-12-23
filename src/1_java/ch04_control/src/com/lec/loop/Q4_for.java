package com.lec.loop;

public class Q4_for {
	public static void main(String[] args) {
		for(int i =1; i<10; i++) {
			for(int j =2; j<10; j++) {
				int k = i*j;
				System.out.printf("%d %c %d = %d\t",j,'*',i,k);
			}
			System.out.println();
		}
	}
}
