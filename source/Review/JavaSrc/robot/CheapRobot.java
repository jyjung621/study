package robot;

import robot.actions.FireNo;
import robot.actions.FlyNo;
import robot.actions.KnifeNo;

public class CheapRobot extends Robot {

	public CheapRobot() {
		// Robot�� ������ ����ϴ� ��
		flyAction = new FlyNo();
		fireAction = new FireNo();
		knifeAction = new KnifeNo();
	}

	@Override
	public void shape() {
		System.out.println("�⺻������ ��, �ٸ�, �Ӹ�, �������� �̷���� ����. �׸��� ���� �� �ֽ��ϴ�. ��x");
	}
}
