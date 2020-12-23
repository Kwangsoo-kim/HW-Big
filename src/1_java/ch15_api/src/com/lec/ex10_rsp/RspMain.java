//20.12.15 kks Example
package com.lec.ex10_rsp;

import java.util.Scanner;

public class RspMain {
	public static void main(String[] args) {
		int com, you=-1;
		String input;
		Scanner sc= new Scanner(System.in);
		do {
			System.out.println("가위, 바위, 보 중에서 하나를 선택");
			input = sc.nextLine().trim();
			com = (int)(Math.random()*3);
			if(input.equals("가위")) {
				you=0;
				System.out.println("가위를 내셨네");
			}else if(input.equals("바위")) {
				you=1;
				System.out.println("바위를 내셨네");
			}else if(input.equals("보")) {
				you=2;
				System.out.println("보를 내셨네");
			}else {
				System.out.println("떼끼");
				continue;
			}
			if(com==0) {
				System.out.println("컴퓨터는 가위");
			}else if(com==1) {
				System.out.println("컴퓨터는 바위");
			}else {
				System.out.println("컴퓨터는 보");
			}
	
			if((you+2)%3==com){
				System.out.println("당신이 이겻다");
			}else if(you==com) {
				System.out.println("비겼다");
			}else {
				System.out.println("컴퓨터가 이겼다");
			}
			
		}while((you+2)%3!=com);
	}
}
