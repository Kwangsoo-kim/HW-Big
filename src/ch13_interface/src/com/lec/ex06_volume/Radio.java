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
			System.out.println("볼륨한도 초과입니다.");
		} else if (v < rmin) {
			System.out.println("최소볼륨은 0입니다.");
		}
		
	}

	@Override
	public void vUp() {
		v += 1;

		if (v > rmax) {
			System.out.println("라디오 볼륨한도 초과");
		} else {
			System.out.println("현재 라디오 볼륨은 : " + v);
		}

	}

	@Override
	public void vUp(int le) {
		v += le;
		if (v > rmax) {
			System.out.println("라디오 볼륨한도 초과");
		} else {
			System.out.println("현재 라디오 볼륨은 : " + v);
		}
	}

	@Override
	public void vDn() {
		v -= 1;
		if (v < rmin) {
			System.out.println("라디오 최소볼륨은 0입니다.");
		} else {
			System.out.println("현재 라디오 볼륨은 : " + v);
		}
	}

	@Override
	public void vDn(int le) {
		v -= le;
		if (v < rmin) {
			System.out.println("라디오 최소볼륨은 0입니다.");
		} else {
			System.out.println("현재 라디오 볼륨은 : " + v);
		}
	}

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}
}
