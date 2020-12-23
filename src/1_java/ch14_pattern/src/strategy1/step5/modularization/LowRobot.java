package strategy1.step5.modularization;

import strategy1.step4.component.FlyNo;
import strategy1.step4.component.KnifeNo;
import strategy1.step4.component.MissileNo;

public class LowRobot extends Robot {

	public LowRobot() {
		setF(new FlyNo());
		setM(new MissileNo());
		setK(new KnifeNo());
	}

	@Override
	public void shape() {
		System.out.println("LowRobot�� �� ,�ٸ� ,�Ӹ� ,�������� �̷���� �ֽ��ϴ�.");

	}

}
