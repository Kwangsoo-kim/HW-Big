//20.12.15 kks equals override
package com.lec.ex05_object;

public class Person {
	private long No;
	public Person(long No) {
		this.No = No;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Person){
			return No==((Person)obj).No;
		}
		return  false;
	}
}
