package test_task;

class Shape {
	private String colour;
	private double area;
	
	public String getColour() {
		return colour;
	}
	
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	public double getArea() {
		return area;
	}	
	
	public void setArea(double area) {
		this.area = area;
	}
}


class Square extends Shape {
	private double sides;
	
	public double getSides() {
		return sides;
	}
	public void setSides(double sides) {
		this.sides = sides;
	}
	public double getPerimetr() {
		return 4 * sides;
	}
	
	@Override
	public double getArea() {
		return sides * sides;
	}
}

class Triangle extends Shape {
	private double sideA;
	private double sideB;
	private double internalAngle;
	
	@Override
	public double getArea() {
		return 0.5 * sideA * sideB * Math.sin(internalAngle);
	}
	
	public double getSideC() {
		return Math.pow(sideA, 2.0) + Math.pow(sideB, 2.0) - 2 * sideA * sideB * Math.cos(internalAngle);
	}
	
	public double bisection() {
		return Math.sqrt(sideA * sideB * (sideA + sideB + getSideC()) * (sideA + sideB - getSideC())) / (sideA + sideB);
	}
	
}

class Circle extends Shape {
	private double radius;
	
	@Override
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	public double getRadius() {
		return radius;
	}
}

class Trapezoid extends Shape {
	private double smollerSideA;
	private double biggerSideB;
	private double legC;
	private double angle;
	
	public double getHeight() {
		return legC * Math.sin(angle);
	}
	
	public double getLegD() {
		return Math.sqrt(Math.pow(getHeight(), 2) + Math.pow(biggerSideB - smollerSideA - legC * Math.cos(angle), 2));
	}
	
	@Override
	public double getArea() {
		return (smollerSideA - biggerSideB) / 2 * getHeight();
	}
}

public class ShapeDisplayer {

	public static void main(String[] args) {
		System.out.println("Hello world");

	}

}

