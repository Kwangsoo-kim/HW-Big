package com.lec.ex;

public class Ex01 {
	public static void main(String[] args) {
		// 1. �迭�� ����� �ʱ�ȭ ���ÿ�
		int[] iArr = {10,20,30,40,50}; 
		iArr[1] = 200; // �迭�� index�� ����(���� index: 0~4)
		for(int idx = 0; idx<5; idx++) { //�Ϲ� for��
			System.out.println(iArr[idx]);
		}
		
		// 2. �迭 ���� ����� �迭�޸� ���� Ȯ��,������ ������ �� ġ��� ������ 0���� ���õȴ�.
		int[] iArr2 =new int[5]; 
		iArr2[0] =999;
		for(int idx =  0; idx<iArr2.length ;  idx++) { //idx<iArr2.length = idx <5
			System.out.println(idx+"��°�� : "+iArr2[idx]);
		}
		
		// 3. �迭 ���� ����
		int[] iArr3;
		iArr3 = new int[5]; //0 0 0 0 0 
//		for(int idx=0; idx<iArr3.length; idx++) { //�Ϲ� for��
//			iArr3[idx]= idx+1;
//		}
		for(int temp : iArr3) {//Ȯ�� for������ �� ���� �ȵȴ�
			temp = 10;
		}
		for(int temp : iArr3) { //Ȯ�� for�� - ���� ����Ҷ���, ���� �ְ�������� ����. Ȯ�� for�����δ� ���� ���� ���Ѵ�,
			System.out.println(temp);
			
		}
		for(int idx=0; idx<iArr3.length; idx++) {
			iArr3[idx] = 10;
		}
		for(int temp : iArr3) { 
			System.out.println(temp);
			
		}
	}
}
