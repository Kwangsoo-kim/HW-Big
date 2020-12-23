package strategy3.modularization;

import strategy3.component.GetSalary;
import strategy3.component.JobMng;

public class Staff extends Person {
	private String part;

	public Staff(String id, String na, String part) {
		super(id, na);
		this.part = part;
		setJ(new JobMng());
		setG(new GetSalary());
	}

	@Override
	public void print() {
		System.out.printf("ID : %s,\t�̸� : %s,\t���� : %s\n", getId(), getNa(), part);
	}
}
