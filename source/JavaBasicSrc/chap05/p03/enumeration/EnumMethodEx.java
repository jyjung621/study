package p03.enumeration;

public class EnumMethodEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// name() 메소드 -> 문자열 리턴
		Week today = Week.SUNDAY;
		String name = today.name();
		System.out.println(name);
		
		
		// ordinal() 메소드 -> 전체 열거 객체 중, 몇 번째 객체인지 알려줌
		int ordinal = today.ordinal();
		System.out.println(ordinal);
		
		
		// compareTo() 메소드 -> 주어진 열거 객체를 기준으로 전후 몇 번째 위치하는지 비교
		Week day1 = Week.MONDAY;
		Week day2 = Week.WEDNESDAY;
		
		int result1 = day1.compareTo(day2);
		int result2 = day2.compareTo(day1);
		
		System.out.println(result1);
		System.out.println(result2);
		
		
		// valuOf() 메소드 -> 동일한 열거 객체를 리턴
		if(args.length == 1)
		{
			String strDay = args[0];
			Week weekDay = Week.valueOf(strDay);
			if((weekDay == Week.SATURDAY) || (weekDay == Week.SUNDAY))
			{
				System.out.println("주말 이군요");
			}
			else
			{
				System.out.println("평일 이군요");
			}
		}
	
		
		// values() 메소드 -> 배열로 변환시켜 줌
		Week[] days = Week.values();
		for(Week day : days)
		{
			System.out.println(day);
		}
	}
}
