package p03.enumeration;

import java.util.Calendar;

public class EnumWeekEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/************************************
		 *  Week가 우리가 만든 enum data type
		 *  today는 Week data type을 갖는 변수 이름
		 ************************************/
		Week today = null;
		// Calender 메소드가 제공하는 객체를 획득  [ getInstance() -> 객체를 가져오는 메소드 ]
		Calendar cal = Calendar.getInstance();
		// cal.get ==> 일(1) ~ 토(7)까지의 숫자를 리턴  
		// [get() -> Return the value for the given calendar field]
		int week = cal.get(Calendar.DAY_OF_WEEK);
		
		switch(week)
		{
			case 1:
				today = Week.SUNDAY;
				break;
			case 2:
				today = Week.MONDAY;
				break;
			case 3:
				today = Week.TUESDAY;
				break;
			case 4:
				today = Week.WEDNESDAY;
				break;
			case 5:
				today = Week.THURSDAY;
				break;
			case 6:
				today = Week.FRIDAY;
				break;
			case 7:
				today = Week.SATURDAY;
				break;
		}
		System.out.println("오늘 요일 : " + today);
		
		if(today == Week.SUNDAY)
		{
			System.out.println("일요일에는 축구를 합니다.");
		}
		else
		{
			System.out.println("열심히 자바 공부합니다.");
		}
	}
}
