package com.lec.ex04_actor;
//다중implements(다형성) 를 이용한 다형성
public class TestMain {
	public static void main(String[] args) {
		Actor p = new Actor("박보검"); //다중implements된 타입이기 때문에 여러 interface사용가능.
		p.ccc();
		p.cci();
		p.offf();
		p.sm();
		p.ms();
		p.mp();
		Ifirefighter fp = p;  //타입이 firefighter타입이라 다른 타입의 메소드는 사용할 수 없다.
		fp.offf();
		fp.sm();
		Ipolice pp =p;  //타입이 police타입이라 다른 타입의 메소드는 사용할 수 없다.
		pp.ccc();
		pp.cci();
		Ichef cp=p; //타입이 chef타입이라 다른 타입의 메소드는 사용할 수 없다.
		cp.mp();
		cp.ms();
	}
}
