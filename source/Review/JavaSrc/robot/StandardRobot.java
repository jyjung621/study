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
		System.out.println("�⺻������ ��, �ٸ�, �Ӹ�, �������� �̷���� ����. �׸��� �Ȱ�, �޸� �� �ֽ��ϴ�. ��x");
	}
}
