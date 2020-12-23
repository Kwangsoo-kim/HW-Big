//201216 kks exception
package com.lec.ex1_tryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;
//예외처리는 최소한의 블록만 잡는편이 좋다. 
public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i;
		int j=1;
		do {
			try {
				System.out.println("첫 번째 수는 ?");
				i = sc.nextInt();
				break;
			}catch(java.util.InputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("첫번재 수에 문자를 넣지 마세요");
				sc.nextLine(); //버퍼를 지우는 역할.
			}
		}while(true);
		
		System.out.println("두 번째 수는 ?");
		try {
			j = sc.nextInt();
			System.out.println("i = "+i+", j= "+j);
			System.out.println("i * j = "+(i*j));
			System.out.println("i / j = "+(i/j));
		}catch(ArithmeticException e) {
			System.out.println(e.getMessage()+"0으로 나누는 것은 패스");
		}catch(InputMismatchException e) {
			System.out.println(e.getMessage());
			System.out.println("두 번째 수를 잘못입력하셔서 1로 초기화");
			sc.nextLine();
		}//일반적으로 try안에 try절을 넣지 않는다
		//catch절이 다수일때는 자손 부모순으로 배열해야한다.
		System.out.println("i + j = "+(i+j));
		System.out.println("i - j = "+(i-j));
		System.out.println("DONE");
		sc.close();
	}
}
