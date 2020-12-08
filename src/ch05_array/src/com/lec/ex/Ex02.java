package com.lec.ex;

public class Ex02 {
	public static void main(String[] args) {
		int[] score = {10,20,30,40,50};
		int[] s = score; 
		s[0] = 100;    //참조형 데이터이기 때문에 값이 바뀐다.
		for(int idx=0;idx<score.length; idx++) {
			System.out.printf("score[%d] = %d, s[%d] = %d\n",idx,score[idx],idx,s[idx]);
		}
	}
}
