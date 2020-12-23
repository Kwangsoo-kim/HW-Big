//201217 kks collection_list
package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex03_ArrayListvsLinkedList {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		LinkedList<String> ll = new LinkedList<String>();

		System.out.println("al 순차적 추가 시간 : " + at(al));
		System.out.println("ll 순차적 추가 시간 : " + at(ll));
		System.out.println("al 중간 인덱스 추가 시간 : " + alt(al));
		System.out.println("ll 중간 인덱스 추가 시간 : " + alt(ll));
		System.out.println("al 끝부터 삭제 시간 : " + rt(al));
		System.out.println("ll 끝부터 삭제 시간 : " + rt(ll));
		System.out.println("al 중간부터 삭제 시간 : " + rmt(al));
		System.out.println("ll 중간부터 삭제 시간 : " + rmt(ll));
	}

	private static long at(List<String> list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			list.add("순차적으로 추가");

		}
		long end = System.currentTimeMillis();
		return end - start;
	}

	private static long alt(List<String> list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			list.add(100, "중간에 추가");
		}
		long end = System.currentTimeMillis();
		return end - start;
	}

	private static long rmt(List<String> list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < list.size(); i++) {
			list.remove(0);
		}
		long end = System.currentTimeMillis();
		return end - start;
	}

	private static long rt(List<String> list) {
		long start = System.currentTimeMillis();
		for (int i = list.size() - 1; i > 1000; i--) {
			list.remove(i);
		}
		long end = System.currentTimeMillis();
		return end - start;
	}

}
