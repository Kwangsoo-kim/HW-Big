package com.lec.ex;

public class VarEx02_04 {
	public static void main(String[] args) {
		//�������� ���
		//1. �ڷ��� ������; 
		int num1; // ���� �ϰ� ���� �Ҵ� �� ��. ��������� ���� �Ҵ� ���־���Ѵ�.
		num1= 10;
		System.out.println("num1="+num1);
		//2. �ڷ��� ������ = ��;
		char c1='��'; // '' - ���� �Ѱ��� ���� �� ����. /"" - ���ڿ� ���� �� �ִ�.
		System.out.println("c1="+c1);
		//3. �ڷ��� ������1, ������2, .... ������n;
		boolean b1, b2, b3;
		b1=true; b2=false; b3=true;
		System.out.print("b1="+b1+"\t b2="+b2+"\t b3="+b3+"\n");
		//4. �ڷ��� ������1=��1, ������2=��,....������m=��n;
		long l1=2200000000l; //�⺻�� int, 22�� �̻��� ������ long������ �Ҵ� �����ϳ� �� �������� L�������־�� �Ѵ�.
		float f1=41.19f , f2=2.24f , f3; //�⺻�� double. float�� f�� �������־�� �Ҵ�ȴ�.
		System.out.println("f1="+f1+"\t f2"+f2);
		System.out.printf("f1 = %3.1f, f2 = %4.1f\n",f1, f2); 
		//printf�� format ���� ���� �Ǽ����� %f, ���̿� x.b - x�� �p�ڸ� ��Ÿ�� ���̳�, b�� �Ҽ��� ���ڸ����� ��Ÿ�� ���̳�.
		// %f : �Ǽ�, %d : ����, %c : ����(1��), %s : ���ڿ�, %x : 16����(�� �Ⱦ���)
		System.out.println("���α׷� ��");      // println - �ڵ����� , \n - �������ִ� ��ɾ�
	}//���α׷� ��

}//Class ��
