//210108 kks lastex3_sdto
package com.lec.student;

public class StudentDto {
	private int rank;
	private String mname;
	private String sname;
	private int score;
	private int expel;
	//insert
	public StudentDto(String mname, String sname, int score) {
		super();
		this.mname = mname;
		this.sname = sname;
		this.score = score;
	}
	//select1
	public StudentDto(int rank, String sname, String mname, int score) {
		super();
		this.rank = rank;
		this.mname = mname;
		this.sname = sname;
		this.score = score;
	}
	//select2
	public StudentDto(int rank, String sname, String mname, int score, int expel) {
		super();
		this.rank = rank;
		this.mname = mname;
		this.sname = sname;
		this.score = score;
		this.expel = expel;
	}
	@Override
	public String toString() {
		return rank +"µî\t"+ sname +"\t"+ mname +"\t"+ score;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getExpel() {
		return expel;
	}
	public void setExpel(int expel) {
		this.expel = expel;
	}
	
	
	
}
