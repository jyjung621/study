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
		System.out.println("�⺻������ ��, �ٸ�, �Ӹ�, �������� �̷���� ����. �׸��� �ɰ�, �޸���, ���� �ֽ��ϴ�. ��o");
	}

}
