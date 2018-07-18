package p05.finalize;

public class FinalizeEx {
	public static void main(String[] args) {
		Counter counter = null;

		for (int i = 1; i <= 50; i++) {
			// counter instance를 heap 메모리에 생성
			counter = new Counter(i);
			// counter에 null을 넣어 counter를 garbage로 만든 것
			counter = null;
			// System.gc(garbage collection) ==>
			// garbage collector에게 빨리 쓰레기를 없애라고 독촉하는 명령어
			System.gc();
		}

	}
}
