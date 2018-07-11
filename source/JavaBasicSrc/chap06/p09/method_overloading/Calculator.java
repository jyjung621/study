package p09.method_overloading;

public class Calculator {
	
	// 정사각형의 넓이
	double areaRectangle(double width)
	{
		System.out.println("square --- called");
		return width * width;
	}
	
	// 직사각형의 넓이
	double areaRectangle(double width, double height)
	{
		System.out.println("rectangle --- called");
		return width * height;
	}
}
