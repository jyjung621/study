package com.oracle.DI02;

public class BMICalculator {
	private double lowWeight;
	private double normal;
	private double overWeight;
	private double obesity;

	public void bmicalculation(double weight, double height) {
		double h = height * 0.01;
		double result = weight / (h * h);

		System.out.println("BMI지수 : " + (int) result);

		if (result < lowWeight) {
			System.out.println("저체중 .");
		} else if (result < normal) {
			System.out.println("정상 .");
		} else if (result < overWeight) {
			System.out.println("과체중 .");
		} else if (result < obesity) {
			System.out.println("비만 .");
		} else {
			System.out.println("고도비만 .");
		}
	}

	public double getLowWeight() {
		return lowWeight;
	}

	public void setLowWeight(double lowWeight) {
		this.lowWeight = lowWeight;
	}

	public double getNormal() {
		return normal;
	}

	public void setNormal(double normal) {
		this.normal = normal;
	}

	public double getOverWeight() {
		return overWeight;
	}

	public void setOverWeight(double overWeight) {
		this.overWeight = overWeight;
	}

	public double getObesity() {
		return obesity;
	}

	public void setObesity(double obesity) {
		this.obesity = obesity;
	}

}
