package com.lec.test;

public class StudentTestMain {
	public static void main(String[] args) {
		Student[] stl = { new Student("정우성", 90, 80, 95), 
				new Student("김하늘", 100, 80, 95),
				new Student("황정민", 95, 80, 90), 
				new Student("강동원", 95, 90, 99), 
				new Student("유아인", 90, 90, 90) };
		int[] tot = new int[5];
		double[] avg = new double[5];
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t\t\t성 적 표");
		System.out.println("-------------------------------------------------------");
		String[] tit = { "번호 ", " 이름\t", "국어\t", "영어\t", "수학\t", "총점\t", "평균\t\n" };
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
		System.out.print(" 총점");
		for (int idx : tot) {
			avg[0] = tot[0] / 5.0;
			avg[1] = tot[1] / 5.0;
			avg[2] = tot[2] / 5.0;
			avg[3] = tot[3] / 5.0;
			avg[4] = tot[4] / 5.0;

			System.out.print("\t" + idx);

		}
		System.out.print("\n 평균");
		for (double idx : avg) {
			System.out.print("\t" + idx);
		}
		System.out.println();
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

	}
}
