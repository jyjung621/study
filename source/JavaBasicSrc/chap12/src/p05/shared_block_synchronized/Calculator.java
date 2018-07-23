package p05.shared_block_synchronized;

public class Calculator {
	private int memory;

	public int getMemory() {
		return memory;
	}

	//	여러개의 thread가 setMemory 메소드를 동시 접근하지 못하고 
	//	특정 시점에 하나의 thread가 setMemory 메소드를 사용하게 하는 방법으로
	//	synchronized를 사용하면 됨
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		
		System.out.println(Thread.currentThread().getName() + " : " + this.memory);
	}
}
