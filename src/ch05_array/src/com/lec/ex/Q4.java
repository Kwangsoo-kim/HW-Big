package com.lec.ex;

public class Q4 {
	public static void main(String[] args) {
		int money =2680;
		int [] coin = {500,100,50,10};
// Ȯ�� for��
		for(int coin1 : coin) {
			System.out.print(coin1+"��¥����"+(money/coin1)+"��. ");
			money= money%coin1;
				
		
		
// �Ϲ� for��		for(int idx=0; idx<coin.length; idx++) {
//				System.out.print(coin[idx]+"��¥����"+(money/coin[idx])+"��, ");
//				money= money%coin[idx];
//             }
			
		}
	}
}
