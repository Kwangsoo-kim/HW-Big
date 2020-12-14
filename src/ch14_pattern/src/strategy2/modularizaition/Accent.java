package strategy2.modularizaition;

import strategy2.component.EngineLow;
import strategy2.component.FuelD;
import strategy2.component.Km20;

public class Accent extends Car {
	public Accent() {
		setE(new EngineLow());
		setK(new Km20());
		setF(new FuelD());
	}

	@Override
	public void shape() {
		System.out.println("Accent는 Door, Sheet, Handle이 있습니다.");
	}

}
