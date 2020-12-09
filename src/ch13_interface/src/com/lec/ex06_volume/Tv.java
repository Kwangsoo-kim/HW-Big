package com.lec.ex06_volume;

public class Tv implements IVolume {
	private int v;
	private final int tmax = 50;
	private final int tmin = 0;

	public Tv() {
		v = 10;
	}

	public Tv(int v) {
		this.v = v;
		if (v > tmax) {
			System.out.println("�����ѵ� �ʰ��Դϴ�.");
		} else if (v < tmin) {
			System.out.println("�ּҺ����� 0�Դϴ�.");
		}
		
	}

	@Override
	public void vUp() {
		v += 2;
		if (v > tmax) {
			System.out.println("Tv �����ѵ� �ʰ�");
		} else {
			System.out.println("Tv ���� ������ : " + v);
		}
	}

	@Override
	public void vUp(int le) {
		v += le;
		if (v > tmax) {
			System.out.println("Tv �����ѵ� �ʰ�");
		} else {
			System.out.println("Tv ���� ������ : " + v);
		}

	}

	@Override
	public void vDn() {
		v -= 2;
		if (v < tmin) {
			System.out.println("Tv �ּҺ����� 0�Դϴ�. ���ư�����");
		} else {
			System.out.println("Tv ���� ������ : " + v);
		}
	}

	@Override
	public void vDn(int le) {
		v -= le;
		if (v < tmin) {
			System.out.println("Tv �ּҺ����� 0�Դϴ�. ���ư�����");
		} else {
			System.out.println("Tv ���� ������ : " + v);
		}
	}

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}
}
