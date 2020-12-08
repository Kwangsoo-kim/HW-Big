package com.lec.loop;

//1~20까지의 누적합을 출력
public class Ex02_for {
	public static void main(String[] args) {
		int tot = 0; // 누적할 변수 한개를 만든다.
//		for (int i = 1; i <= 20; i++) {// tot 변수에 i 값을 계속 누적
//			tot = tot + i;
//		}
//		System.out.println("1~20까지의 누적합은 : " + tot);

//1+2+3+4+5+6+...+20 =210으로 출력하는 방법
		for (int i = 1; i < 21; i++) {
			tot = tot + i;
			if (i != 20) {
				System.out.print(i + "+");
			} else {
				System.out.print(i + "=");
			}
		}
		System.out.println(tot);
	}
}
