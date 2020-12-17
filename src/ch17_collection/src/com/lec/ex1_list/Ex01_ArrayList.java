//201217 kks collection_list 
package com.lec.ex1_list;

import java.util.ArrayList;

public class Ex01_ArrayList {
	public static void main(String[] args) {
		//일반 배열
		String[] array = new String[3];
		array[0]="str0";
		array[1]="str1";
		array[2]="str2";
		for(int i=0;i<array.length;i++) {
			System.out.println("array["+i+"] = "+array[i]);
		}
		//collection ArrayList, 객체만 사용가능
		ArrayList<String> al = new ArrayList<String>();
		al.add("str0"); //0 index
		al.add("str1"); //1 index
		al.add("str2"); //2 index
		al.add(1,"111111"); //1번 index로 들어감. 원래 점유하고 있던 내용들은 다음 index로 밀린다.
		for(int i =0;i<al.size();i++) { //arraylist는 size를 사용 일반배열은 length
			System.out.println("arrayList의"+i+"번쨰 = "+al.get(i));
		}
		al.remove(1); //1번 index값 삭제, 2번 index가 1번 index로 내려온다. 순차적.
		System.out.println(al);
		al.clear(); // 모든 데이터 삭제.
		//if(al.size()==0)
		if(al.isEmpty()) {
			System.out.println("al 비워짐");
		}
		for(String t : al) { //확장for문은 사용법이 똑같다.
			System.out.println(t);
		}
		
	}
}
