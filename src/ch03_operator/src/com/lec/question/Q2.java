package com.lec.question;
import java.util.Scanner;
public class Q2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print(" ������ �Է��ϼ���: ");
		int n = sc.nextInt();
		System.out.println(n%2==0 ? "¦�� �Դϴ�.":"Ȧ�� �Դϴ�.");
		sc.close();
	}

}
