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
			System.out.println("볼륨한도 초과입니다.");
		} else if (v < tmin) {
			System.out.println("최소볼륨은 0입니다.");
		}
		
	}

	@Override
	public void vUp() {
		v += 2;
		if (v > tmax) {
			System.out.println("Tv 볼륨한도 초과");
		} else {
			System.out.println("Tv 현재 볼륨은 : " + v);
		}
	}

	@Override
	public void vUp(int le) {
		v += le;
		if (v > tmax) {
			System.out.println("Tv 볼륨한도 초과");
		} else {
			System.out.println("Tv 현재 볼륨은 : " + v);
		}

	}

	@Override
	public void vDn() {
		v -= 2;
		if (v < tmin) {
			System.out.println("Tv 최소볼륨은 0입니다. 돌아가세요");
		} else {
			System.out.println("Tv 현재 볼륨은 : " + v);
		}
	}

	@Override
	public void vDn(int le) {
		v -= le;
		if (v < tmin) {
			System.out.println("Tv 최소볼륨은 0입니다. 돌아가세요");
		} else {
			System.out.println("Tv 현재 볼륨은 : " + v);
		}
	}

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}
}
