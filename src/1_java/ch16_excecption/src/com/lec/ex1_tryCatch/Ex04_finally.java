//201216 kks exception
package com.lec.ex1_tryCatch;

public class Ex04_finally {
	public static void main(String[] args) {
		int[] iArr = {0,1,2};
		for(int i =0;i<=iArr.length;i++) {
			try {
				System.out.println("iArr["+i+"] = "+iArr[i]);
			}catch(java.lang.ArrayIndexOutOfBoundsException e) {
				System.out.println("예외 메세지 : "+e.getMessage());
			}finally {
				System.out.println("try절 실행 후에도, catch절 실행 후에도 여기는 실행함.");
			}
		}
		System.out.println("프로그램 끝");
	}
}
