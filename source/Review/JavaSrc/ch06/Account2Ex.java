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
			System.out.println(ownerName + "ÀÎÃâ ¾ÈµÊ --> ÇöÀçÀÜ¾× ºÎÁ· : ÀÜ¾× -> " + balance + " ¿äÃ»±Ý¾×-> " + amt);
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
		Account2 ac1 = new Account2("±¹¹Î 1111", "±èÃÌÁÖ", 10000);
		Account2 ac2 = new Account2("½ÅÇÑ 2222", "Á¤¼±¾Æ", 20000);
		Account2 ac3 = new Account2("³óÇù 3333", "¾È¿¹Àº", 30000);

		ac1.deposit(5000);
		ac1.getBal();
		ac1.withdraw(3000);
		ac1.getBal();
		System.out.println("ÀºÇà°èÁÂ: " + ac1.accountNo + " ¼ºÇÔ: " + ac1.ownerName + " ÀÜ¾×: " + ac1.balance);

		ac2.deposit(15000);
		ac2.getBal();
		ac2.withdraw(43000);
		ac2.getBal();
		System.out.println("ÀºÇà°èÁÂ: " + ac2.accountNo + " ¼ºÇÔ: " + ac2.ownerName + " ÀÜ¾×: " + ac2.balance);

		ac3.deposit(12000);
		ac3.getBal();
		ac3.withdraw(41000);
		ac3.getBal();
		System.out.println("ÀºÇà°èÁÂ: " + ac3.accountNo + " ¼ºÇÔ: " + ac3.ownerName + " ÀÜ¾×: " + ac3.balance);

	}

}
