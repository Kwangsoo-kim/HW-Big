//201217 kks collection_list
package com.lec.ex1_list;

import java.util.LinkedList;
//Arraylist�� ������ ����. �߰��� add�ϴ°�찡 ����Ҷ� ���.
public class Ex02_LinkedList {
	public static void main(String[] args) {
		LinkedList<String> ls = new LinkedList<String>();
		ls.add("str0");
		ls.add("str1");
		ls.add("str2");
		ls.add(1,"1111");
		System.out.println(ls);
		for(int i =0;i<ls.size();i++) {
			System.out.println(ls.get(i));
		}
		ls.remove(1);
		System.out.println(ls);
		ls.clear();
		if(ls.isEmpty()) {
			System.out.println("����ִ�");
		}
	}
}
