package strategy1.step5.modularization;

import strategy1.step4.component.FlyNo;
import strategy1.step4.component.KnifeWood;
import strategy1.step4.component.MissileYes;

public class StandardRobot extends Robot {

	public StandardRobot() {
		setF(new FlyNo());
		setM(new MissileYes());
		setK(new KnifeWood());
	}

	@Override
	public void shape() {
		System.out.println("StandardRobot�� �� ,�ٸ� ,�Ӹ� ,�������� �̷���� �ֽ��ϴ�.");
		
	}

}
