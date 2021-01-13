package com.lec.superMarket;

public class CustomerDto {
	private String cid;
	private String ctel;
	private String cname;
	private String lname;
	private int cpoint;
	private int camount;
	private int lvup;

	public CustomerDto(String cid, String ctel, String cname, int lvup) {
		this.cid = cid;
		this.ctel = ctel;
		this.cname = cname;
		this.lvup = lvup;
	}


	public CustomerDto(String cid ,String ctel, String cname, int point, int camount, String lname, int lvup) {
		this.cid = cid;
		this.ctel = ctel;
		this.cname = cname;
		this.cpoint = point;
		this.camount = camount;
		this.lname = lname;
		this.lvup = lvup;
	}

	public CustomerDto(String ctel, String cname) {
		this.ctel = ctel;
		this.cname = cname;
	}
	@Override
	public String toString() {
		return cid + "\t " + ctel + "\t" + cname + "\t" + cpoint + "\t" + camount + "\t" + lname + "\t" + lvup;
	}


	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCtel() {
		return ctel;
	}

	public void setCtel(String ctel) {
		this.ctel = ctel;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getCpoint() {
		return cpoint;
	}

	public void setCpoint(int cpoint) {
		this.cpoint = cpoint;
	}

	public int getCamount() {
		return camount;
	}

	public void setCamount(int camount) {
		this.camount = camount;
	}

	public int getLvup() {
		return lvup;
	}

	public void setLvup(int lvup) {
		this.lvup = lvup;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}

}
