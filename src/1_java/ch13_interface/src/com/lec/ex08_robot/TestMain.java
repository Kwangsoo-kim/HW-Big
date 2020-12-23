package com.lec.ex08_robot;

public class TestMain {
	public static void main(String[] args) {
		RobotOrder order = new RobotOrder();
		Robot d = new DanceRobot();
		Robot s = new SingRobot();
		Robot dr = new DrawRobot();
		Robot[] rs = { d, s, dr };
		order.action(d);
		order.action(s);
		order.action(dr);
		for(Robot i : rs) {
			order.action(i);
		}
	}
}
