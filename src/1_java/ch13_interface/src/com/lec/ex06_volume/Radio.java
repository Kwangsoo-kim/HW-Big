package com.lec.ex06_volume;

public class Radio implements IVolume {
	private int v;
	private final int rmax = 35;
	private final int rmin = 0;

	public Radio() {
		v = 10;
	}

	public Radio(int v) {
		this.v = v;
		if (v > rmax) {
			System.out.println("�����ѵ� �ʰ��Դϴ�.");
		} else if (v < rmin) {
			System.out.println("�ּҺ����� 0�Դϴ�.");
		}
		
	}

	@Override
	public void vUp() {
		v += 1;

		if (v > rmax) {
			System.out.println("���� �����ѵ� �ʰ�");
		} else {
			System.out.println("���� ���� ������ : " + v);
		}

	}

	@Override
	public void vUp(int le) {
		v += le;
		if (v > rmax) {
			System.out.println("���� �����ѵ� �ʰ�");
		} else {
			System.out.println("���� ���� ������ : " + v);
		}
	}

	@Override
	public void vDn() {
		v -= 1;
		if (v < rmin) {
			System.out.println("���� �ּҺ����� 0�Դϴ�.");
		} else {
			System.out.println("���� ���� ������ : " + v);
		}
	}

	@Override
	public void vDn(int le) {
		v -= le;
		if (v < rmin) {
			System.out.println("���� �ּҺ����� 0�Դϴ�.");
		} else {
			System.out.println("���� ���� ������ : " + v);
		}
	}

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}
}
