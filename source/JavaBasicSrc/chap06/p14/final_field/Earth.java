package p14.final_field;

public class Earth {
	/*
	 * 	변수 EARTH_RADIUS, EARTH_SURFACE_AREA를 상수로 표현하고 싶을 때,
	 * 	변수이름 앞에 static final로 선언하면 됨.
	 */
	static final double EARTH_RADIUS = 6400;
	static final double EARTH_SURFACE_AREA;
	
	static
	{
		EARTH_SURFACE_AREA = 4 * Math.PI * EARTH_RADIUS * EARTH_RADIUS;
	}
}
