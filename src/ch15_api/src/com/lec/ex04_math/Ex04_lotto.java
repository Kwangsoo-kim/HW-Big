//20.12.15 kks random api
package com.lec.ex04_math;

import java.util.Random;

public class Ex04_lotto {
	public static void main(String[] args) {
		Random r = new Random();
		int[] lotto = new int[6];
		for(int i = 0; i<lotto.length;i++) {
			int temp = r.nextInt(45)+1;
			int j;
			for(j=0;j<i;j++) {
				if(temp==lotto[j]) {
					i--;
					break;
				}
			}
			if(temp!=lotto[j]) {
				lotto[j]=temp;
				System.out.println(temp);
			}
		}
	
		
		
		
		
	}
}
