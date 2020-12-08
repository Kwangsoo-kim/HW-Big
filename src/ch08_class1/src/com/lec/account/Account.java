package com.lec.account;

/*ÀºÇà°èÁÂ Å¬·¡½º 
 *  µ¥ÀÌÅÍ : 	°èÁÂ¹øÈ£(ac:String)
 *			¿¹±ÝÁÖ   (on:String)
 *  		ÀÜ¾×	  (bal:int)
 *  ¸Þ¼Òµå : 	¿¹±ÝÇÑ´Ù(void dp(int money))
 *  		ÀÎÃâÇÏ´Ù(void wd(int money)), ÀÜ¾×ºÎÁ· 
 *  
 *  
 *  
 */
public class Account {
	private String ac;
	private String on;
	private int bal;

	public Account() {
	}

	public Account(String ac, String on, int bal) {
		this.ac = ac;
		this.on = on;
		this.bal = bal;
	}

	public Account(String ac, String on) {
		this.ac = ac;
		this.on = on;
	}

	public void dp(int money) {
		bal += money;
		System.out.println(money + "¿ø ¿¹±ÝµÇ¾ú´Ù");
	}
	public void info() {
		System.out.println("°èÁÂ¹øÈ£ : "+ ac +","+on+"´Ô ÀÜ¾×Àº : "+bal+"¿ø");
	}

	public void wd(int money) { // ÀÜ¾× ºÎÁ·½Ã ¶¼³¢ return
		// System.out.println(bal>=money ? bal-=money : "?" );

		if (bal >= money) {
			bal -= money;
		} else {
			System.out.println("ÀÜ¾× ºÎÁ·. ¶¼³¢");
		}
	}

	public void setAc(String ac) {
		this.ac = ac;
	}

	public void setOn(String on) {
		this.on = on;
	}

	public void setBal(int bal) {
		this.bal = bal;
	}

	public String getAc() {
		return ac;
	}

	public String getOn() {
		return on;
	}

	public int getBal() {
		return bal;
	}
}
