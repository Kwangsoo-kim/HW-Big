package com.lec.loop;
// i가 1일  때 누적합은 x이다.(i가 1~10)
public class Ex08_while {
	public static void main(String[] args) {
		int i = 1;
		int sum = 0;
		int sum2 = 0;
		while(i<=10) {
			sum += i; // sum= sum+i;
			System.out.printf("i가 %d일 떄 누적합은 %d이다\n",i,sum);
			// 위와 똑같다. System.out.println("i가 "+i+"일 떄 누적합은"+sum+"이다");
			++i;
		}
		System.out.println();
		
		for(int j =1; j<11; j++) {
			sum2 += j;
			System.out.printf("j가 %d일 떄 누적합은 %d이다\n",j,sum2);
		}
	}
}
