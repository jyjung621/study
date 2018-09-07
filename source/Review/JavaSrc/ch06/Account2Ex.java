package ch06;

class Account2 {
	String accountNo;
	String ownerName;
	int balance;

	public Account2(String amtno, String ownerName, int bal) {
		accountNo = amtno;
		this.ownerName = ownerName;
		balance = bal;
	}

	void deposit(int amt) {
		balance += amt;
	}

	void withdraw(int amt) {
		if (balance < amt) {
			System.out.println(ownerName + "���� �ȵ� --> �����ܾ� ���� : �ܾ� -> " + balance + " ��û�ݾ�-> " + amt);
		} else {
			balance -= amt;
		}
	}

	int getBal() {
		return balance;
	}
}

public class Account2Ex {
	public static void main(String[] args) {
		Account2 ac1 = new Account2("���� 1111", "������", 10000);
		Account2 ac2 = new Account2("���� 2222", "������", 20000);
		Account2 ac3 = new Account2("���� 3333", "�ȿ���", 30000);

		ac1.deposit(5000);
		ac1.getBal();
		ac1.withdraw(3000);
		ac1.getBal();
		System.out.println("�������: " + ac1.accountNo + " ����: " + ac1.ownerName + " �ܾ�: " + ac1.balance);

		ac2.deposit(15000);
		ac2.getBal();
		ac2.withdraw(43000);
		ac2.getBal();
		System.out.println("�������: " + ac2.accountNo + " ����: " + ac2.ownerName + " �ܾ�: " + ac2.balance);

		ac3.deposit(12000);
		ac3.getBal();
		ac3.withdraw(41000);
		ac3.getBal();
		System.out.println("�������: " + ac3.accountNo + " ����: " + ac3.ownerName + " �ܾ�: " + ac3.balance);

	}

}
