package com.lec.ex;

public class Q3 {
	public static void main(String[] args) {
		int[] a= {76,45,34,89,100,50,90,92};
		int sum = 0;
		int avg = 0;
		int min = 999;
		int max = -999;
		for(int i=0;i<a.length;i++) {
			sum+=a[i];
			avg = sum/a.length;
			if(a[i]>max) {
				max =a[i];
			}
			if(a[i]<min) {
				min =a[i];
			}
		
		}
		System.out.println("총합은 : "+ sum);
		System.out.println("평균은 : "+ avg);
		System.out.println("최소값은 : "+ min );
		System.out.println("최대값은 : "+ max );
		
	}
}
