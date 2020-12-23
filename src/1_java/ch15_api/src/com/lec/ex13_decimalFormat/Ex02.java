//20.12.15 kks decimalFormat_for
package com.lec.ex13_decimalFormat;

import java.text.DecimalFormat;
//�����ڸ��� :#(������ ���, ������ ���x) 0(�ݵ�� ���)
// ,%,E
public class Ex02 {
	public static void main(String[] args) {
		String[] pattens = {"00000000.00000",
				"########.##",
				"#,###,###.000",
				"#.##%",
				"#.#####E00"
		};
		double number = 1234567.8889;
		for(String p : pattens) {
			DecimalFormat df = new DecimalFormat(p);
			System.out.println(df.format(number));
		}
		
	}

}
