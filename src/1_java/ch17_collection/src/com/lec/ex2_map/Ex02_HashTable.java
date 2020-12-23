//201217 kks collection_Map
package com.lec.ex2_map;

import java.util.Hashtable;
import java.util.Iterator;

public class Ex02_HashTable {
	public static void main(String[] args) {
		Hashtable<String, String> ht = new Hashtable<String,String>();
		ht.put("010-9999-9999", "È«±æµ¿");
		ht.put("010-8888-8888", "ÀÌ±æµ¿");
		ht.put("010-7777-7777", "±è±æµ¿");
		ht.put("010-6666-6666", "»ï±æµ¿");
		System.out.println(ht);
		Iterator<String> it = ht.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key+" : "+ ht.get(key));
		}
}		
}
