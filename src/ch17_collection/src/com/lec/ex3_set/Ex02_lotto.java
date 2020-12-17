//201217 kks collection_set
package com.lec.ex3_set;

import java.util.HashSet;
import java.util.Random;

public class Ex02_lotto {
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();
		Random r = new Random();
		while (hs.size() < 6) {
			hs.add(r.nextInt(45) + 1);
		}
		System.out.println(hs);
	}
}
