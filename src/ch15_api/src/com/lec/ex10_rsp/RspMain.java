//20.12.15 kks Example
package com.lec.ex10_rsp;

import java.util.Scanner;

public class RspMain {
	public static void main(String[] args) {
		int com, you=-1;
		String input;
		Scanner sc= new Scanner(System.in);
		do {
			System.out.println("����, ����, �� �߿��� �ϳ��� ����");
			input = sc.nextLine().trim();
			com = (int)(Math.random()*3);
			if(input.equals("����")) {
				you=0;
				System.out.println("������ ���̳�");
			}else if(input.equals("����")) {
				you=1;
				System.out.println("������ ���̳�");
			}else if(input.equals("��")) {
				you=2;
				System.out.println("���� ���̳�");
			}else {
				System.out.println("����");
				continue;
			}
			if(com==0) {
				System.out.println("��ǻ�ʹ� ����");
			}else if(com==1) {
				System.out.println("��ǻ�ʹ� ����");
			}else {
				System.out.println("��ǻ�ʹ� ��");
			}
	
			if((you+2)%3==com){
				System.out.println("����� �̰��");
			}else if(you==com) {
				System.out.println("����");
			}else {
				System.out.println("��ǻ�Ͱ� �̰��");
			}
			
		}while((you+2)%3!=com);
	}
}
