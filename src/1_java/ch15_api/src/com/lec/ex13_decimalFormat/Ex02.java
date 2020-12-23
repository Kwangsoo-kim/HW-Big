//20.12.15 kks decimalFormat_for
package com.lec.ex13_decimalFormat;

import java.text.DecimalFormat;
//숫자자리에 :#(있으면 출력, 없으면 출력x) 0(반드시 출력)
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
