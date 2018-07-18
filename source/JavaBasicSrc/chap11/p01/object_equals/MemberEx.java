package p01.object_equals;

public class MemberEx {

	public static void main(String[] args) {
		Member obj1 = new Member("blue", 29);
		Member obj2 = new Member("blue", 31);
		Member obj3 = new Member("red", 30);
		Member obj4 = new Member("blue", 29);

		if (obj1.equals(obj2)) {
			System.out.println("obj1과 obj2는 동등합니다.");
		} else {
			System.out.println("obj1과 obj2는 동등하지 않습니다.");
		}

		if (obj1.equals(obj4)) {
			System.out.println("obj1과 obj4는 동등합니다.");
		} else {
			System.out.println("obj1과 obj4는 동등하지 않습니다.");
		}

		if (obj1.equals(obj3)) {
			System.out.println("obj1과 obj3는 동등합니다.");
		} else {
			System.out.println("obj1과 obj3는 동등하지 않습니다.");
		}

	}

}
