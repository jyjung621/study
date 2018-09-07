package robot;

import robot.actions.FireOk;
import robot.actions.FlyOk;
import robot.actions.KnifeOk;

public class SuperRobot extends Robot {

	
	public SuperRobot() {
		// TODO Auto-generated constructor stub
		flyAction = new FlyOk();
		fireAction = new FireOk();
		knifeAction = new KnifeOk();
	}

	@Override
	public void shape() {
		// TODO Auto-generated method stub
		System.out.println("기본적으로 팔, 다리, 머리, 몸통으로 이루어져 있음. 그리고 걸고, 달리고, 날수 있습니다. 검o");
	}

}
