//201217 kks collection_Map
package com.lec.ex2_map;

import java.util.HashMap;
import java.util.Iterator;
//map��, ��ü�� ������ ���� �� �ִ�. key���� �����ؾ� �Ѵ�. ������ �������.
public class Ex01_HashMap {
	public static void main(String[] args) {
		HashMap<Integer,String > hm = new HashMap<Integer, String>();
		hm.put(0, "str11");
		hm.put(1, "str22");
		hm.put(2, "str33");
		System.out.println(hm.get(2));
		System.out.println("remove �� : "+hm);
		hm.remove(22);
		System.out.println("remove �� : "+hm);
		hm.clear(); 
		hm.put(0, "ȫ�浿");
		hm.put(1, "��浿");
		hm.put(2, "�̱浿");
		hm.put(3, "���浿");
		Iterator<Integer> it = hm.keySet().iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			System.out.println(key+"�� �����ʹ� "+hm.get(key));
		}
		
		
	}
}
