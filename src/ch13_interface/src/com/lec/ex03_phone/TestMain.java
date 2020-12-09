package com.lec.ex03_phone;

public class TestMain {
	public static void main(String[] args) {
		IAcor m1 = new Amodel();
		IAcor m2 = new Bmodel();
		IAcor m3 = new Cmodel();
		IAcor[] m = {new Amodel(),
				     new Bmodel(),
				     new Cmodel()
		};
		for(IAcor i:m) {
			System.out.println("==================================");
			System.out.println(i.getNa());
			i.dmb();
			i.lte();
			i.remotec();
			
		}
		for(int i =0;i<m.length;i++) {
			System.out.println("==================================");
			System.out.println(m[i].getNa());
			m[i].dmb();
			m[i].lte();
			m[i].remotec();
		}
	}
}
