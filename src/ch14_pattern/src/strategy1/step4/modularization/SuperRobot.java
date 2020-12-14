package strategy1.step4.modularization;


import strategy1.step4.component.FlyImpl;
import strategy1.step4.component.FlyYes;
import strategy1.step4.component.KnifeImpl;
import strategy1.step4.component.KnifeLazer;
import strategy1.step4.component.MissileImpl;
import strategy1.step4.component.MissileYes;

//날 수 있음, 미사일 있음, 레이저 검 있음.
public class SuperRobot extends Robot {
	private FlyImpl f;
	private MissileImpl m;
	private KnifeImpl k;
	public SuperRobot() {
		f = new FlyYes();
		m = new MissileYes();
		k = new KnifeLazer();
//		setF(new FlyYes());
//		setM(new MissileYes());
//		setK(new KnifeLazer());
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
