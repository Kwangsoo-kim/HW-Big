package strategy3.modularization;

import strategy3.component.GetStudentPay;
import strategy3.component.JobStudy;

public class Student extends Person {
	private String ban;

	public Student(String id, String na, String ban) {
		super(id, na);
		this.ban = ban;
		setJ(new JobStudy());
		setG(new GetStudentPay());

	}

	@Override
	public void print() {
		System.out.printf("ID : %s,\t이름 : %s,\t과목 : %s\n", getId(), getNa(), ban);

	}

}
