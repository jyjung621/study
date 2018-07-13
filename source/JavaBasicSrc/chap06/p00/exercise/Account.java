package p00.exercise;

/*public class Account {	// 19번 문제
	
	//	field
	private int balance;
	final int MIN_BALANCE = 0;
	final int MAX_BALANCE = 1000000;
	
	// constructor

	
	//	method
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		if((balance >= MIN_BALANCE) && (balance <= MAX_BALANCE))
		{
			this.balance = balance;
		}
	}
}*/

public class Account {
	
	// field
	private String ano;
	private String owner;
	private int valance;
	
	//	constructor
	public Account(String ano, String owner, int valance) {
		this.ano = ano;
		this.owner = owner;
		this.valance = valance;
	}
	
	//	method	Getter & Setter
	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getValance() {
		return valance;
	}

	public void setValance(int valance) {
		this.valance = valance;
	}
		
}
