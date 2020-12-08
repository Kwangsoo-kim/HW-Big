package com.lec.ex06lunch;

public class Child1 extends LunchMenu {
	public Child1(int ri,int bg, int sp, int mk,int ba, int al) {
		super(ri,bg,sp,mk,ba,al);	
	}
	@Override
	public int calculate() {
		return getAl()+getBa()+getBg()+getRi()+getSp();
	}

}
