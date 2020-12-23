//201217 kks collection_set
package com.lec.ex3_set;

import java.util.HashSet;
import java.util.Iterator;

//중복이 없고, 순서가 없는 배열
public class Ex01_HashSet {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		// "str0","str1","str2","str3","str2"
		hs.add("str0");
		hs.add("str1");
		hs.add("str2");
		hs.add("str3");
		hs.add("str2"); // 중복된 데이터
		System.out.println(hs);
		System.out.println("hashset 사이즈 : " + hs.size());
		hs.add("str2"); // 중복된 데이터
		System.out.println(hs);
		Iterator<String> it = hs.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}
}
