package com.lec.ex1;

public class StudentMain {
	public static void main(String[] args) {
		Student st1 = new Student("���켺", 90, 90, 90);
		Student st2 = new Student("���ϴ�", 90, 90, 91);
		Student st3 = new Student("Ȳ����", 80, 80, 80);
		Student st4 = new Student("������", 80, 80, 81);
		Student st5 = new Student("������", 70, 70, 70);
		Student[] stt = {
				new Student("���켺", 90, 90, 90),
				new Student("���ϴ�", 90, 90, 91),
				new Student("Ȳ����", 80, 80, 80),
				new Student("������", 80, 80, 81),
				new Student("������", 70, 70, 70)
				
		};
		int[] tot = new int[5];
		double[] avg= new double[5];
		for (int i = 1; i < 50; i++) {
			System.out.print('��');
		}
		System.out.println();
		System.out.println("\t\t\t" + "����ǥ" + "\t\t\t\t\t\t\t\t\t");
		for (int i = 1; i < 50; i++) {
			System.out.print('-');
		}
		System.out.println();
		System.out.printf("%s\t%s\t%s\t%s\t%s\t%s", "�̸�", "����", "����", "����", "����", "���");
		System.out.println();
		for(Student st : stt) {
			st.print();
			tot[0]+=st.getK();
			tot[1]+=st.getE();
			tot[2]+=st.getM();
			tot[3] += st.getTot();
			tot[4] += st.getAvg();
			
		}
//		st1.print();
//		st2.print();
//		st3.print();
//		st4.print();
//		st5.print();
		System.out.println();
		for (int i = 1; i < 50; i++) {
			System.out.print('��');
		}
		System.out.println();
		System.out.print("����");
		for(int idx=0 ; idx<avg.length ; idx++) { // ��յ� ���
			avg[idx] = tot[idx] / stt.length;
			System.out.print("\t "+tot[idx]);
		}
		System.out.print("\n���");
		for(double a : avg) {
			System.out.print("\t"+a);
		}
		System.out.println();

	}
}
