package com.lec.ex;

public class Q2 {
	public static void main(String[] args) {
		int[][] arr = { {5,5,5,5,5}, 
				        {10,10,10,10,10}, 
				        {20,20,20,20,20}, 
				        {30,30,30,30,30}};
		int sum = 0;
		int b;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				b =arr[i][j];
				sum += b;
				
			}
			
			

		}
		System.out.println("�迭�� ����� ������ �հ�� "+sum);
	}
}
