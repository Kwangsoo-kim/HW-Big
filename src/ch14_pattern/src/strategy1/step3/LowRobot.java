package strategy1.step3;

public class LowRobot extends Robot{

	@Override
	public void actionFly() {
		System.out.println("날 수 없다");
	}

	@Override
	public void actionMissile() {
		System.out.println("쏠 수 없다");
		
	}

	@Override
	public void actionKnife() {
		System.out.println("검은 없다.");
		
	}
	
	
}
