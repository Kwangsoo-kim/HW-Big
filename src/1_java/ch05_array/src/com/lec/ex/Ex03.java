package com.lec.ex;

public class Ex03 {
	public static void main(String[] args) {
		//값은 같게, 공간은 다르게 하는 방법. 배열의 복사 방법
		int[] score = {10,20,30,40,50};
		int[] s = new int[score.length];
//		for(int i=0; i<score.length; i++) {
//			s[i] = score[i];
//		}
	
		//api 이용방법 
		System.arraycopy(score, 0, s, 0, score.length);    //(복사할 배열,인덱스,복사시킬 배열,복사시킬 인덱스,복사할 인덱스 범위)
		s[0]=999;
		for(int i=0;i<s.length; i++) {
			System.out.printf("s[%d] = %d, score[%d] = %d\n",i,s[i],i,score[i]);
		}
	}
}
