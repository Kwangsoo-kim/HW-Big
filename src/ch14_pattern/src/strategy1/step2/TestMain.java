package strategy1.step2;

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
			if(i instanceof SuperRobot) {
				SuperRobot ti = (SuperRobot)i;
				ti.actionFly();
				ti.actionMissile();
				ti.actionKnife();
			}else if(i instanceof StandardRobot) {
				StandardRobot ti = (StandardRobot)i;
				ti.actionFly();
				ti.actionMissile();
				ti.actionKnife();
			}else if(i instanceof LowRobot) {
				LowRobot ti = (LowRobot)i;
				ti.actionFly();
				ti.actionMissile();
				ti.actionKnife();
			}
		}
	}
}
