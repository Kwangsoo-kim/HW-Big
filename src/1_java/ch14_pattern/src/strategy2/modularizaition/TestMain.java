package strategy2.modularizaition;

import strategy2.component.FuelH;
import strategy2.component.Km20;

public class TestMain {

	public static void main(String[] args) {
		Car c1 = new Genesis();
		Car c2 = new Sonata();
		Car c3 = new Accent();
		Car[] c = {c1,c2,c3};
		for(Car i : c) {
			i.dirve();
			i.shape();
			i.Engine();
			i.Kpl();
			i.Fuel();
		}	
		System.out.println("�ҳ�Ÿ�� ���̺긮��� ��ü�ϰ� ���� 20���� ��ü �� �ҳ�Ÿ�� ������ ����.");
		 c2.setF(new FuelH());
		 c2.setK(new Km20());
		 for(Car i : c) {
				i.dirve();
				i.shape();
				i.Engine();
				i.Kpl();
				i.Fuel();
		 
		 
		}
	}
}
