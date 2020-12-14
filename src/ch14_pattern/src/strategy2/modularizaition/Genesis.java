package strategy2.modularizaition;

import strategy2.component.EngineHigh;
import strategy2.component.FuelG;
import strategy2.component.Km10;

public class Genesis extends Car {
	public Genesis() {
		setE(new EngineHigh());
		setK(new Km10());
		setF(new FuelG());
		
	}
	@Override
	public void shape() {
		System.out.println("GENESIS는 Door, Sheet, Handle이 있습니다.");
	}

}
