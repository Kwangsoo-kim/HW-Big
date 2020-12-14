package strategy3.modularization;

import strategy3.component.GetSalary;
import strategy3.component.JobLec;

public class Lecturer extends Person {
	private String sub;

	public Lecturer(String id, String na, String sub) {
		super(id, na);
		this.sub = sub;
		setG(new GetSalary());
		setJ(new JobLec());
	}

	@Override
	public void print() {
		System.out.printf("ID : %s,\t이름 : %s,\t과목 : %s\n", getId(), getNa(), sub);
	}
}
