//201217 kks collection_set
package com.lec.ex3_set;

public class Student {
	private String na;
	private int g;

	public Student(String na, int g) {
		this.na = na;
		this.g = g;
	}

	@Override
	public String toString() {
		return na + " : " + g;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Student) {
//			boolean nchk= na.equals(((Student)obj).na);
//			boolean gchk= g==((Student)obj).g;
//			return nchk && gchk;
			return toString().equals(obj.toString());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
