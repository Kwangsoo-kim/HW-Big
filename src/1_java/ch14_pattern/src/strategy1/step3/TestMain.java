package strategy1.step3;

public class TestMain {
	public static void main(String[] args) {
		SuperRobot r1 = new SuperRobot();
		StandardRobot r2 = new StandardRobot();
		LowRobot r3 = new LowRobot();
		Robot[] r = {new SuperRobot(), 
					 new StandardRobot(),
					 new LowRobot()
		};
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
