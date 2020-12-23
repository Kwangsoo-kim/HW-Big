package strategy1.step1;

public class TestMain {
	public static void main(String[] args) {
		SuperRobot sr = new SuperRobot();
		StandardRobot dr = new StandardRobot();
		LowRobot lr = new LowRobot();
		sr.shape();
		sr.actionWalk();
		sr.acationRun();
		sr.actionFly();
		sr.actionMissile();
		sr.actionKnife();
		dr.shape();
		dr.actionWalk();
		dr.acationRun();
		dr.actionFly();
		dr.actionMissile();
		dr.actionKnife();
		lr.shape();
		lr.actionWalk();
		lr.acationRun();
		lr.actionFly();
		lr.actionMissile();
		lr.actionKnife();
	}
	
}
