package strategy1.step5.modularization;

import strategy1.step4.component.FlyHi;
import strategy1.step4.component.FlyYes;

public class TestMain {
	public static void main(String[] args) {
		Robot r1 = new SuperRobot();
		Robot r2 = new StandardRobot();
		Robot r3 = new LowRobot();
		Robot[] r = {r1,r2,r3};
		for(Robot i : r) {
			i.shape();
			i.actionWalk();
			i.acationRun();
			i.actionFly();
			i.actionMissile();
			i.actionKnife();
		}
		//LowRobot�� �� �� �ִ� �κ����� ���׷��̵�
		r3.setF(new FlyYes());
		System.out.println("���׷��̵� �� ");
		for(Robot i : r) {
			i.shape();
			i.actionWalk();
			i.acationRun();
			i.actionFly();
			i.actionMissile();
			i.actionKnife();
		}
		//SuperRobot�� �� ���� ���� �κ����� ���׷��̵�
		r1.setF(new FlyHi());
		System.out.println("���׷��̵� �� ");
		for(Robot i : r) {
			i.shape();
			i.actionWalk();
			i.acationRun();
			i.actionFly();
			i.actionMissile();
			i.actionKnife();
		}
	}
}
