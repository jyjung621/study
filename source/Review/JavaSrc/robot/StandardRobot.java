package robot;

import robot.actions.FireOk;
import robot.actions.FlyNo;
import robot.actions.KnifeAction;
import robot.actions.KnifeNo;

public class StandardRobot extends Robot {

	public StandardRobot() {
		flyAction = new FlyNo();
		fireAction = new FireOk();
		KnifeAction = new KnifeNo();
	}

	@Override
	public void shape() {
		// TODO Auto-generated method stub
		System.out.println("기본적으로 팔, 다리, 머리, 몸통으로 이루어져 있음. 그리고 걷고, 달릴 수 있습니다. 검x");
	}
}
