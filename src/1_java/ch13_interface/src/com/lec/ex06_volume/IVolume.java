package com.lec.ex06_volume;

public interface IVolume {
	public void vUp();
	public void vUp(int le);
	public void vDn();
	public void vDn(int le);
	//예외적인 상황에 default를 사용 default메소드를 사용할 수 있다.일반적으로 사용하지 않는다.
	public default void muete() {
		System.out.println("무음처리합니다.");
	}
}
