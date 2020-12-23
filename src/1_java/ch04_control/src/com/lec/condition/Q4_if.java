package com.lec.condition;

import java.util.Scanner;


// 사용자로부터 가위(0) , 바위(1), 보(2) 중 하나를 입력받고
// 컴퓨터도 가위(0),바위(1),보(2) 중 하나를 선택해서 승자를 출력
public class Q4_if {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("가위, 바위, 보 중 하나를 선택 : ");
		int you = sc.nextInt();
		if(you==0) {
			System.out.println("가위를 내셨네");
		}else if(you==1) {
			System.out.println("바위를 내셨네");
		}else if(you==2) {
			System.out.println("보를 내셨네");
		}else {
			System.out.println("떼끼");
			System.exit(0);
		}
		sc.close();
		int com = (int)(Math.random()*3);
		//Math.random() : 0 부터 1보다 작은 실수 난수를 발생
		//System.out.println( (int) (Math.random()*3)); //0~3미만 난수 발생
		if(com==0) {
			System.out.println("컴퓨터는 가위");
		}else if(com==1) {
			System.out.println("컴퓨터는 바위");
		}else {
			System.out.println("컴퓨터는 보");
		}
//패턴을 사용한 절
		if((you+2)%3==com){
			System.out.println("당신이 이겻다");
		}else if(you==com) {
			System.out.println("비겼다");
		}else {
			System.out.println("컴퓨터가 이겼다");
		}
		
		
		
		
 //중복if 사용한 절
		if(you==0) {
			if(com==1) {
				System.out.println("컴퓨터가승");
			}else if(com==2) {
				System.out.println("당신이 승");
			}else {
				System.out.println("비기셨네요");
			}
		}else if(you==1) {
			if(com==1) {
				System.out.println("비기셨네요");
			}else if(com==2) {
				System.out.println("컴퓨터가 승");
			}else {
				System.out.println("당신이 승");
			}
		}else if(you==2){
			if(com==1) {
				System.out.println("당신이 승");
			}else if(com==2) {
				System.out.println("비기셨네요");
			}else {
				System.out.println("컴퓨터가 승");
			}
	    }
	}
}
