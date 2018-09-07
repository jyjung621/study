package robot;

import robot.actions.FireNo;
import robot.actions.FlyNo;
import robot.actions.KnifeNo;

public class CheapRobot extends Robot {

	public CheapRobot() {
		// Robot의 변수를 사용하는 것
		flyAction = new FlyNo();
		fireAction = new FireNo();
		knifeAction = new KnifeNo();
	}

	@Override
	public void shape() {
		System.out.println("기본적으로 팔, 다리, 머리, 몸통으로 이루어져 있음. 그리고 걸을 수 있습니다. 검x");
	}
}
