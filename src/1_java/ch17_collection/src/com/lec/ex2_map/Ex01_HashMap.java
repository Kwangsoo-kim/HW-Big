//201217 kks collection_Map
package com.lec.ex2_map;

import java.util.HashMap;
import java.util.Iterator;
//map형, 객체를 변수로 받을 수 있다. key값은 유일해야 한다. 순서는 상관없다.
public class Ex01_HashMap {
	public static void main(String[] args) {
		HashMap<Integer,String > hm = new HashMap<Integer, String>();
		hm.put(0, "str11");
		hm.put(1, "str22");
		hm.put(2, "str33");
		System.out.println(hm.get(2));
		System.out.println("remove 전 : "+hm);
		hm.remove(22);
		System.out.println("remove 후 : "+hm);
		hm.clear(); 
		hm.put(0, "홍길동");
		hm.put(1, "김길동");
		hm.put(2, "이길동");
		hm.put(3, "유길동");
		Iterator<Integer> it = hm.keySet().iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			System.out.println(key+"의 데이터는 "+hm.get(key));
		}
		
		
	}
}
