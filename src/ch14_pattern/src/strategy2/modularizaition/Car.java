package strategy2.modularizaition;

import strategy2.component.EngineImpl;
import strategy2.component.FuelImpl;
import strategy2.component.KmImpl;

public abstract class Car {
	private EngineImpl e;
	private KmImpl k;
	private FuelImpl f;
	public void dirve() {
		System.out.println("운행 할 수 있습니다.");
	}
	public abstract void shape();
	public void Engine() {
		e.Engine();
	}
	public void Kpl() {
		k.Kpl();
	}
	public void Fuel() {
		f.Fuel();
	}
	public void setE(EngineImpl e) {
		this.e = e;
	}
	public void setK(KmImpl k) {
		this.k = k;
	}
	public void setF(FuelImpl f) {
		this.f = f;
	}
}
