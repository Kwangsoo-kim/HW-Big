package com.lec.ex1_string;

import java.util.Scanner;

//전화번호 뒷자리로 친구찾기
public class Ex07searchf {
	public static void main(String[] args) {
		Friend[] fs = { new Friend("홍길동", "000-1111-1111", "5-12"), new Friend("신길동", "010-8888-8888", "01-10"),
				new Friend("헌길동", "010-2222-2222", "03-12") };
		// 찾을 친구의 전화 번호 뒷자리를 입력받는다.
		// fs배열에서 해당 전화번호 뒷자리와 같은 친구가 있으면 친구를 출력
		// 없으면 없다고 풀력
		int i;
		String ff;
		Scanner sc = new Scanner(System.in);
		System.out.println("친구의 전화 번호 뒷자리를 입력하세요");
		ff = sc.next();
		for (i = 0; i < fs.length; i++) {
			String t = fs[i].getTel();
			String p = t.substring(t.lastIndexOf("-") + 1);

			if (p.equals(ff)) {
				System.out.println(fs[i]);
				fs[i].print();
				break;
			}
		}
		if (i == fs.length) {
			System.out.println("해당번호 친구가 없습니다.");
		}
	}
}
