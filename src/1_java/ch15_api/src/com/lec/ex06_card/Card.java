//20.12.15 kks equals override
package com.lec.ex06_card;

public class Card {
	private String Kind;
	private int num;
	public Card(String kind,int num) {
		this.Kind = kind;
		this.num = num;
	}
	@Override
	public String toString() {
		return "카드 모양은 " +Kind+" "+" "+num;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Card) {
			return num==((Card)obj).num && Kind==((Card)obj).Kind;
		}
		return false;
	}
	public String getKind() {
		return Kind;
	}
	public int getNum() {
		return num;
	}	
}
