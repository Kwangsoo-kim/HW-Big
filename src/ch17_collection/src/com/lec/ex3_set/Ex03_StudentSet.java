//201217 kks collection_set
package com.lec.ex3_set;

import java.util.HashSet;
import java.util.Iterator;

public class Ex03_StudentSet {
	public static void main(String[] args) {
		HashSet<Student> st = new HashSet<Student>();
		Student s1 = new Student("이순신", 6);
		st.add(s1);
		st.add(s1);
		System.out.println(st);
		st.add(new Student("홍길동", 5));
		st.add(new Student("장보고", 1));
		st.add(new Student("장보고", 1));
		System.out.println(st);
		Iterator<Student> it = st.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
