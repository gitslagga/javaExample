package top.slagga;

public class ThinkingJava {
	public static void main(String[] args) {
//		new Cartoon();
//		new Chess(11);
//		new PlaceSetting(22);

//		CADSystem x = new CADSystem(47);
//		try {
//
//		} finally {
//			x.cleanup();
//		}
		
//		Bart b = new Bart();
//		b.doh(1);
//		b.doh('x');
//		b.doh(1.0f);
//		b.doh(new Milhouse());
		
//		Car car = new Car();
//		car.left.window.rollup();
//		car.wheels[0].inflate(72);
		
	}
}

class Engine {
	public void start() {}
	public void rev() {}
	public void stop() {}
}
class Wheel {
	public void inflate(int psi) {}
}
class Window {
	public void rollup() {}
	public void rolldown() {}
}
class Door {
 	public Window window = new Window();
	public void open() {}
	public void close() {}
}

class Car {
	public Engine engine = new Engine();
	public Wheel[] wheels = new Wheel[4];
	public Door left = new Door(), right = new Door();
	Car() {
		for(int i = 0; i < 4; i++) {
			wheels[i] = new Wheel();
		}
	}
}

class Home {
	char doh(char c) {
		System.out.println("doh(char)");
		return 'd';
	}
	float doh (float f) {
		System.out.println("doh(float)");
		return 1.0f;
	}
}
class Milhouse {}

class Bart extends Home {
	void doh (Milhouse m) {}
}

class Shape {
	Shape(int i) {
		System.out.println("Shape constructor");
	}

	void cleanup() {
		System.out.println("Shape cleanup");
	}
}

class Circle extends Shape {
	Circle(int i) {
		super(i);
		System.out.println("Drawing a Circle");
	}

	void cleanup() {
		System.out.println("Erasing a Circle");
		super.cleanup();
	}
}

class Triangle extends Shape {
	Triangle(int i) {
		super(i);
		System.out.println("Drawing a Triangle");
	}

	void cleanup() {
		System.out.println("Erasing a Triangle");
		super.cleanup();
	}
}

class Line extends Shape {
	private int start, end;

	Line(int start, int end) {
		super(start);
		this.start = start;
		this.end = end;
		System.out.println("Drawing a Line: " + start + ", " + end);
	}

	void cleanup() {
		System.out.println("Erasing a Line: " + start + ", " + end);
		super.cleanup();
	}
}

class CADSystem extends Shape {
	private Circle c;
	private Triangle t;
	private Line[] lines = new Line[10];

	CADSystem(int i) {
		super(i + 1);
		for (int j = 0; j < 10; j++)
			lines[j] = new Line(j, j * j);
		c = new Circle(1);
		t = new Triangle(1);
		System.out.println("Combined constructor");
	}

	void cleanup() {
		System.out.println("CADSystem.cleanup()");
		t.cleanup();
		c.cleanup();
		for (int i = 0; i < lines.length; i++)
			lines[i].cleanup();
		super.cleanup();
	}
} /// :~

class Plate {
	Plate(int i) {
		System.out.println("Plate constructor");
	}
}

class DinnerPlate extends Plate {
	DinnerPlate(int i) {
		super(i);
		System.out.println("DinnerPlate constructor");
	}
}

class Utensil {
	Utensil(int i) {
		System.out.println("Utensil constructor");
	}
}

class Spoon extends Utensil {
	Spoon(int i) {
		super(i);
		System.out.println("Spoon constructor");
	}
}

class Fork extends Utensil {
	Fork(int i) {
		super(i);
		System.out.println("Fork constructor");
	}
}

class Knife extends Utensil {
	Knife(int i) {
		super(i);
		System.out.println("Knife constructor");
	}
}

class Custom {
	Custom(int i) {
		System.out.println("Custom constructor");
	}
}

class PlaceSetting extends Custom {
	Spoon spoon;
	Fork fork;
	Knife knife;
	DinnerPlate dinnerPlate;

	PlaceSetting(int i) {
		super(i + 1);
		spoon = new Spoon(i + 2);
		fork = new Fork(i + 3);
		knife = new Knife(i + 4);
		dinnerPlate = new DinnerPlate(i + 5);
		System.out.println("PlaceSetting constructor");
	}
}

class Art {
	Art() {
		System.out.println("Art constructor");
	}
}

class Drawing extends Art {
	Drawing() {
		System.out.println("Drawing constructor");
	}
}

class Cartoon extends Drawing {
	Cartoon() {
		System.out.println("Cartoon constructor");
	}
}

class Game {
	Game(int i) {
		System.out.println("Game constructor");
	}
}

class BoardGame extends Game {
	BoardGame(int i) {
		super(i);
		System.out.println("BoardGame constructor");
	}
}

class Chess extends BoardGame {
	Chess(int i) {
		super(i);
		System.out.println("Chess constructor");
	}
}