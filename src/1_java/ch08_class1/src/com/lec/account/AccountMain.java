package com.lec.account;

public class AccountMain {
	public static void main(String[] args) {
		Account hong = new Account("110-1","全辨悼", 10000);
		Account hong1 = new Account("110-2", "全老");
		Account hong2 = new Account();
		hong2.setAc("110-3");
		hong2.setOn("全捧");
		hong.dp(10000);
		hong.info();
		hong1.wd(1);
		hong1.info();
		hong2.dp(10000);
		hong2.wd(20000);
		hong2.info();
	}
}
