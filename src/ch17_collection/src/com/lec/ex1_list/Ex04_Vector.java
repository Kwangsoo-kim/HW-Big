//201217 kks collection_list
package com.lec.ex1_list;

import java.util.Vector;

public class Ex04_Vector {
	public static void main(String[] args) {
		Vector<Object> vec = new Vector<Object>();
		Aclass a = new Aclass();
		Bclass b = new Bclass();
		vec.add(a); //0번 index
		vec.add(b); //1번 index
		vec.add("C"); //2번 index
		vec.add(10); //3번 index
		System.out.println(vec);
		for(int i=0;i<vec.size();i++) {
			System.out.println(vec.get(i));
		}
		if(vec.isEmpty()) {
			System.out.println("vec에 데이터가 없습니다.");
		}else {
			System.out.println("vec에 데이터가 있습니다.");
		}
		vec.clear();
		if(vec.isEmpty()) {
			System.out.println("vec에 데이터가 없습니다.");
		}else {
			System.out.println("vec에 데이터가 있습니다.");
		}
	}
}
