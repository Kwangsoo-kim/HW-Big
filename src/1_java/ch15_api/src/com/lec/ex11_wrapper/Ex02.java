//20.12.15 kks wrapper
package com.lec.ex11_wrapper;
// ���������Լ�
public class Ex02 {
	public static void main(String[] args) {
		int total = valueSum("10","20","30","40");
		System.out.println("���� ���� �հ�� "+total);
	}
	private static int valueSum(String...value) {
		int result=0; //�����Լ�
		for(int i=0;i<value.length;i++) {
			//Integer.parseInt(val) : val���ڿ��� ������ �ٲ��ش�.
			result +=Integer.parseInt(value[i]);
		}
		return result;
	}
}
