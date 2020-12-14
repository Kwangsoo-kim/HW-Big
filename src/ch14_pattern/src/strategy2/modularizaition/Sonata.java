package strategy2.modularizaition;

import strategy2.component.EngineMid;
import strategy2.component.FuelG;
import strategy2.component.Km15;

public class Sonata extends Car {
	public Sonata() {
		setE(new EngineMid());
		setK(new Km15());
		setF(new FuelG());
	}

	@Override
	public void shape() {
		System.out.println("SONATA는 Door, Sheet, Handle이 있습니다.");
	}

}
