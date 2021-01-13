//210111 kks lastex4_ssdto
package com.lec.studentGUI;

public class StudentSwingDto {
	private String sno;
	private int rank;
	private String mname;
	private String sname;
	private int score;
	private int expel;


	public StudentSwingDto(String sname, String mname, int score) {
		this.sname = sname;
		this.mname = mname;
		this.score = score;
	}
	public StudentSwingDto(int rank, String sname, String mname, int score) {
		this.rank = rank;
		this.sname = sname;
		this.mname = mname;
		this.score = score;
	}
	public StudentSwingDto(String sno, String sname, String mname, int score) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.mname = mname;
		this.score = score;
	}
	@Override
	public String toString() {
		if (sname.length() < 12) {
			return rank + "µî\t" + sname + "\t\t" + mname + "\t" + score;
		} else {
			return rank + "µî\t" + sname + "\t" + mname + "\t" + score;
		}
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

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}
}
