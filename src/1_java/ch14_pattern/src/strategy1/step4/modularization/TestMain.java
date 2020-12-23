package strategy1.step4.modularization;

import strategy1.step4.component.FlyHi;
import strategy1.step4.component.FlyYes;

public class TestMain {
	public static void main(String[] args) {
		SuperRobot r1 = new SuperRobot();
		StandardRobot r2 = new StandardRobot();
		LowRobot r3 = new LowRobot();
		Robot[] r = {r1,r2,r3};
		for(Robot i : r) {
			i.shape();
			i.actionWalk();
			i.acationRun();
			i.actionFly();
			i.actionMissile();
			i.actionKnife();
		}
		//LowRobot을 날 수 있는 로봇으로 업그레이드
		r3.setF(new FlyYes());
		System.out.println("업그레이드 후 ");
		for(Robot i : r) {
			i.shape();
			i.actionWalk();
			i.acationRun();
			i.actionFly();
			i.actionMissile();
			i.actionKnife();
		}
		//SuperRobot을 더 높이 나는 로봇으로 업그레이드
		r1.setF(new FlyHi());
		System.out.println("업그레이드 후 ");
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
