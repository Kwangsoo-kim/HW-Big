package com.lec.test;

public class StudentTestMain {
	public static void main(String[] args) {
		Student[] stl = { new Student("���켺", 90, 80, 95), 
				new Student("���ϴ�", 100, 80, 95),
				new Student("Ȳ����", 95, 80, 90), 
				new Student("������", 95, 90, 99), 
				new Student("������", 90, 90, 90) };
		int[] tot = new int[5];
		double[] avg = new double[5];
		System.out.println("��������������������������������������������������������");
		System.out.println("\t\t\t�� �� ǥ");
		System.out.println("-------------------------------------------------------");
		String[] tit = { "��ȣ ", " �̸�\t", "����\t", "����\t", "����\t", "����\t", "���\t\n" };
		for (String temp : tit) {
			System.out.print(temp);
		}
		System.out.println("-------------------------------------------------------");
		for (Student i : stl) {
			i.print();
			tot[0] = tot[0] + i.getK();
			tot[1] = tot[1] + i.getE();
			tot[2] = tot[2] + i.getM();
			tot[3] = tot[3] + i.getTot();
			tot[4] = tot[4] + i.getAvg();

		}
		System.out.println("-------------------------------------------------------");
		System.out.print(" ����");
		for (int idx : tot) {
			avg[0] = tot[0] / 5.0;
			avg[1] = tot[1] / 5.0;
			avg[2] = tot[2] / 5.0;
			avg[3] = tot[3] / 5.0;
			avg[4] = tot[4] / 5.0;

			System.out.print("\t" + idx);

		}
		System.out.print("\n ���");
		for (double idx : avg) {
			System.out.print("\t" + idx);
		}
		System.out.println();
		System.out.println("��������������������������������������������������������");

	}
}
