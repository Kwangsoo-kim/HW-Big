package com.lec.ex;

public class Q4 {
	public static void main(String[] args) {
		int money =2680;
		int [] coin = {500,100,50,10};
// 확장 for문
		for(int coin1 : coin) {
			System.out.print(coin1+"원짜리는"+(money/coin1)+"개. ");
			money= money%coin1;
				
		
		
// 일반 for문		for(int idx=0; idx<coin.length; idx++) {
//				System.out.print(coin[idx]+"원짜리는"+(money/coin[idx])+"개, ");
//				money= money%coin[idx];
//             }
			
		}
	}
}
