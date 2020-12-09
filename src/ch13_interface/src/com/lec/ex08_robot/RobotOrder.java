package com.lec.ex08_robot;
//instance of 객체를 물어보는 언어 True,False로 나옴.
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
