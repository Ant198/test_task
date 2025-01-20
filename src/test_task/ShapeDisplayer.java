package test_task;

import java.util.Random;
import java.util.Scanner;

abstract class Figure {
	private String color;
	
	public Figure(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	public abstract int getArea();
	
	public abstract String draw();
}


class Square extends Figure {
	private int side;
	
	public Square(String color, int side) {
		super(color);
		this.side = side;
	}
	
	public int getSides() {
		return side;
	}

	public int getPerimetr() {
		return 4 * side;
	}
	
	@Override
	public int getArea() {
		return side * side;
	}
	
	@Override
	public String draw() {
		return "Фігура: квадрат, площа: " + getArea() + " кв. од., периметр: " + getPerimetr() + " од., колір: " + getColor();
	}
}

class Triangle extends Figure {
	private int sideA;
	private int sideB;
	private double internalAngle;
	
	public Triangle(String color, int sideA, int sideB, int internalAngle) {
		super(color);
		this.sideA = sideA;
		this.sideB = sideB;
		this.internalAngle = Math.toRadians(internalAngle);
	}
	
	public int getSideC() {
		return (int) Math.round(Math.sqrt(Math.pow(sideA, 2.0) + Math.pow(sideB, 2.0) - 2 * sideA * sideB * Math.cos(internalAngle)));
	}
	
	public int getBisection() {
		return (int) Math.round(Math.sqrt(sideA * sideB * (sideA + sideB + getSideC()) * (sideA + sideB - getSideC())) / (sideA + sideB));
	}
	
	@Override
	public int getArea() {
		return (int) Math.round(0.5 * sideA * sideB * Math.sin(internalAngle));
	}

	@Override
	public String draw() {
		return "Фігура: трикутник, площа: " + getArea() + " кв. од., довжина бісектриси: " + getBisection() + " од., колір: " + getColor();
	}
	
}

class Circle extends Figure {
	private int radius;
	
	public Circle(String color, int radius) {
		super(color);
		this.radius = radius;
	}
	
	public int getRadius() {
		return radius;
	}
	
	@Override
	public int getArea() {
		return (int) Math.round(Math.PI * Math.pow(radius, 2));
	}
	
	
	@Override
	public String draw() {
		return "Фігура: коло, площа: " + getArea() + " кв. од., радіус: " + getRadius() + " од., колір: " + getColor();
	}
}

class Trapezoid extends Figure {
	private int smollerSideA;
	private int biggerSideB;
	private int legC;
	private double angle;
	
	public Trapezoid(String color, int smollerSideA, int biggerSideB, int legC, int angle) {
		super(color);
		this.smollerSideA = smollerSideA;
		this.biggerSideB = biggerSideB;
		this.legC = legC;
		this.angle = Math.toRadians(angle);
	}
	
	public int getHeight() {
		return (int) Math.round(legC * Math.sin(angle));
	}
	
	public int getLegD() {
		return (int) Math.round(Math.sqrt(Math.pow(getHeight(), 2) + Math.pow(biggerSideB - smollerSideA - legC * Math.cos(angle), 2)));
	}
	
	@Override
	public int getArea() {
		return Math.round((biggerSideB + smollerSideA) / 2 * getHeight());
	}

	@Override
	public String draw() {
		return "Фігура: трапеція, площа: " + getArea() + " кв. од., висота: " + getHeight() + " од., колір: " + getColor();
	}

}

class FigureFactory {
	private static String[] COLORS = {"red", "orange", "yellow", "green", "blue", "indigo", "violet"}; 
		
	public static String buildFigure() {
		Random random = new Random();
		int typeFigure = random.nextInt(4);
		if (typeFigure == 0) {
			return new Square(COLORS[random.nextInt(COLORS.length)], 1 + random.nextInt(100)).draw();
		} else if (typeFigure == 1) {
			return new Triangle(COLORS[random.nextInt(COLORS.length)], 1 + random.nextInt(100), 1 + random.nextInt(100), 1 + random.nextInt(179)).draw();
		} else if (typeFigure == 2) {
			return new Circle(COLORS[random.nextInt(COLORS.length)], 1 + random.nextInt(100)).draw();
		} else {
			int smallerSideA = 1 + random.nextInt(100);
			int biggerSideB = 1 + smallerSideA + random.nextInt(100);
			return new Trapezoid(COLORS[random.nextInt(COLORS.length)], smallerSideA, biggerSideB, 1 + random.nextInt(100), 1 + random.nextInt(179)).draw();
		}
	}
	
}

public class ShapeDisplayer {
	public static String[] showAllFigures(int arrayLength) {
		String[] listOfObjects = new String[arrayLength];
		for(int i = 0; i < arrayLength; i++) {
			listOfObjects[i] = FigureFactory.buildFigure();
		}
		return listOfObjects;
	}
		
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int arrayLength = 0;
		while(arrayLength <= 0) {
			System.out.print("Введіть кількість об'єктів: ");
			arrayLength = scanner.nextInt();
			if(arrayLength > 0) {
				for(String figure : showAllFigures(arrayLength)) {
					System.out.println(figure);
				}
				scanner.close();
			} else {
				System.out.println("Введено не коректну кількість!!! ");
			}
		}		
				
	}
	
}