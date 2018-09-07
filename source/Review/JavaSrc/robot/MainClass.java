package robot;

public class MainClass {
	public static void main(String[] args) {
		System.out.println("SuperRobot�� �ֹ� ��� �Խ��ϴ�. ���� �����մϴ�.");
		Robot superRobot = new SuperRobot();
		superRobot.shape();
		superRobot.actionBasic();
		superRobot.actionFly();
		superRobot.actionFire();
		superRobot.actionKnife();
		System.out.println("------------------------------------------");
		System.out.println("SuperRobot�� �ֹ� ��� �Խ��ϴ�. ���� �����մϴ�.");
		Robot standardRobot = new StandardRobot();
		standardRobot.shape();
		standardRobot.actionBasic();
		standardRobot.actionFly();
		standardRobot.actionFire();
		standardRobot.actionKnife();
		System.out.println("------------------------------------------");
		System.out.println("CheapRobot�� �ֹ� ��� �Խ��ϴ�. ���� �����մϴ�.");
		Robot cheapRobot = new CheapRobot();
		cheapRobot.shape();
		cheapRobot.actionBasic();
		cheapRobot.actionFly();	
		cheapRobot.actionFire();
		cheapRobot.actionKnife();
		System.out.println("------------------------------------------");
	}
}
