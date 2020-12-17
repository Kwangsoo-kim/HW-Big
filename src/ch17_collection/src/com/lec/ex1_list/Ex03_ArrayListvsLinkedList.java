//201217 kks collection_list
package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex03_ArrayListvsLinkedList {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		LinkedList<String> ll = new LinkedList<String>();

		System.out.println("al ������ �߰� �ð� : " + at(al));
		System.out.println("ll ������ �߰� �ð� : " + at(ll));
		System.out.println("al �߰� �ε��� �߰� �ð� : " + alt(al));
		System.out.println("ll �߰� �ε��� �߰� �ð� : " + alt(ll));
		System.out.println("al ������ ���� �ð� : " + rt(al));
		System.out.println("ll ������ ���� �ð� : " + rt(ll));
		System.out.println("al �߰����� ���� �ð� : " + rmt(al));
		System.out.println("ll �߰����� ���� �ð� : " + rmt(ll));
	}

	private static long at(List<String> list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			list.add("���������� �߰�");

		}
		long end = System.currentTimeMillis();
		return end - start;
	}

	private static long alt(List<String> list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			list.add(100, "�߰��� �߰�");
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
