package strategy1.step4.modularization;

import strategy1.step4.component.FlyImpl;
import strategy1.step4.component.FlyNo;
import strategy1.step4.component.KnifeImpl;
import strategy1.step4.component.KnifeNo;
import strategy1.step4.component.MissileImpl;
import strategy1.step4.component.MissileNo;

public class LowRobot extends Robot{
	private FlyImpl f;
	private MissileImpl m;
	private KnifeImpl k;
	public LowRobot() {
		f = new FlyNo();
		m = new MissileNo();
		k = new KnifeNo();
//		setF(new FlyNo());
//		setM(new MissileNo());
//		setK(new KnifeNo());
	}

	@Override
	public void actionFly() {
		f.fly();
	}

	@Override
	public void actionMissile() {
		m.Msissile();
	}

	@Override
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
