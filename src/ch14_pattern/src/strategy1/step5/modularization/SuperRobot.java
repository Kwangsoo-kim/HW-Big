package strategy1.step5.modularization;

import strategy1.step4.component.FlyYes;
import strategy1.step4.component.KnifeLazer;
import strategy1.step4.component.MissileYes;

//날 수 있음, 미사일 있음, 레이저 검 있음.
public class SuperRobot extends Robot {

	public SuperRobot() {
		setF(new FlyYes());
		setM(new MissileYes());
		setK(new KnifeLazer());
	}

	@Override
	public void shape() {
		System.out.println("SuperRobot은 팔 ,다리 ,머리 ,몸통으로 이루어져 있습니다.");
		
	}

}
