package com.lec.ex;

public class Ex03 {
	public static void main(String[] args) {
		//���� ����, ������ �ٸ��� �ϴ� ���. �迭�� ���� ���
		int[] score = {10,20,30,40,50};
		int[] s = new int[score.length];
//		for(int i=0; i<score.length; i++) {
//			s[i] = score[i];
//		}
	
		//api �̿��� 
		System.arraycopy(score, 0, s, 0, score.length);    //(������ �迭,�ε���,�����ų �迭,�����ų �ε���,������ �ε��� ����)
		s[0]=999;
		for(int i=0;i<s.length; i++) {
			System.out.printf("s[%d] = %d, score[%d] = %d\n",i,s[i],i,score[i]);
		}
	}
}
