//201217 kks collection_list 
package com.lec.ex1_list;

import java.util.ArrayList;

public class Ex01_ArrayList {
	public static void main(String[] args) {
		//�Ϲ� �迭
		String[] array = new String[3];
		array[0]="str0";
		array[1]="str1";
		array[2]="str2";
		for(int i=0;i<array.length;i++) {
			System.out.println("array["+i+"] = "+array[i]);
		}
		//collection ArrayList, ��ü�� ��밡��
		ArrayList<String> al = new ArrayList<String>();
		al.add("str0"); //0 index
		al.add("str1"); //1 index
		al.add("str2"); //2 index
		al.add(1,"111111"); //1�� index�� ��. ���� �����ϰ� �ִ� ������� ���� index�� �и���.
		for(int i =0;i<al.size();i++) { //arraylist�� size�� ��� �Ϲݹ迭�� length
			System.out.println("arrayList��"+i+"���� = "+al.get(i));
		}
		al.remove(1); //1�� index�� ����, 2�� index�� 1�� index�� �����´�. ������.
		System.out.println(al);
		al.clear(); // ��� ������ ����.
		//if(al.size()==0)
		if(al.isEmpty()) {
			System.out.println("al �����");
		}
		for(String t : al) { //Ȯ��for���� ������ �Ȱ���.
			System.out.println(t);
		}
		
	}
}
