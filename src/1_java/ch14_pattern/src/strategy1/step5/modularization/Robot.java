package strategy1.step5.modularization;

import strategy1.step4.component.FlyImpl;
import strategy1.step4.component.KnifeImpl;
import strategy1.step4.component.MissileImpl;

public abstract class Robot {
	private FlyImpl f;
	private MissileImpl m;
	private KnifeImpl k;

	public abstract void shape();

	public void actionWalk() {
		System.out.println("걸을 수 있다.");
	}

	public void acationRun() {
		System.out.println("뛸 수 있다.");
	}

	public void actionFly() {
		f.fly();
	}

	public void actionMissile() {
		m.Msissile();
	}

	public void actionKnife() {
		k.Knife();
	}

	public void setF(FlyImpl f) {
		this.f = f;
	}

	public void setM(MissileImpl m) {
		this.m = m;
	}

	public void setK(KnifeImpl k) {
		this.k = k;
	}
}
