package strategy3.modularization;

import strategy3.component.GetImpl;
import strategy3.component.JobImpl;

public class Person {
	private JobImpl j;
	private GetImpl g;
	private String id;
	private String na;
	public Person() {}
	public Person(String id,String na) {
		this.id=id;
		this.na=na;
	}
	
	public void print() {
	}
	
	public void job() {
		j.job();
	}
	public void get() {
		g.Get();
	}
	public void setJ(JobImpl j) {
		this.j = j;
	}
	public void setG(GetImpl g) {
		this.g = g;
	}

	public JobImpl getJ() {
		return j;
	}

	public GetImpl getG() {
		return g;
	}

	public String getId() {
		return id;
	}

	public String getNa() {
		return na;
	}
}
