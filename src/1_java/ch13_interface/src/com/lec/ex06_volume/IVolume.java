package com.lec.ex06_volume;

public interface IVolume {
	public void vUp();
	public void vUp(int le);
	public void vDn();
	public void vDn(int le);
	//�������� ��Ȳ�� default�� ��� default�޼ҵ带 ����� �� �ִ�.�Ϲ������� ������� �ʴ´�.
	public default void muete() {
		System.out.println("����ó���մϴ�.");
	}
}
