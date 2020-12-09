package com.lec.ex08_robot;
//instance of ��ü�� ����� ��� True,False�� ����.
public class RobotOrder {
	public void action(Robot robot) {
		if(robot instanceof DanceRobot) {
			((DanceRobot)robot).dance();
		}else if(robot instanceof SingRobot) {
			((SingRobot)robot).sing();
		}else if(robot instanceof DrawRobot) {
			((DrawRobot)robot).draw();
		}
	}
}
