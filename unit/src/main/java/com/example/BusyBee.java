package com.example;

import java.text.NumberFormat;

public class BusyBee extends Object {
	BusyBee() {
		System.out.println("Busy Bee construct");
	}

	public static void main(String[] args) {

//		numberFormat();

//	    System.out.println(Garbage.i);
//		Garbage garbage = new Garbage();

//		Cookie cookie = new Cookie();
//		cookie.foo();

//	    SprinklerSystem x = new SprinklerSystem();
//	    x.print();

//		Bath bath = new Bath();
//		bath.print();

//		BusyBee[] busyBee = new BusyBee[4];
//		new BusyBee();

		new ConcurrentWorker().work();
	}

	static void numberFormat() {
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		NumberFormat percentFormat = NumberFormat.getPercentInstance();
		double num = 0.1;
		System.out.println(currencyFormat.format(num));
		System.out.println(percentFormat.format(num));
	}

}

class Worker {
	public void work() {
		for (int i = 0; i < 100; i++) { System.out.println("Working" + i); }
	}
}
class ConcurrentWorker extends Worker {
	public void work () {
		Thread thread = new Thread(super::work);
		thread.start();
	}
}

class WaterSource {
	private String s;

	WaterSource() {
		System.out.println("WaterSource()");
		s = new String("Constructed");
	}

	public String toString() {
		return s;
	}
}

class SprinklerSystem {
	private String valve1, valve2, valve3, valve4;
	WaterSource source;
	int i;
	float f;

	void print() {
		System.out.println("valve1 = " + valve1);
		System.out.println("valve2 = " + valve2);
		System.out.println("valve3 = " + valve3);
		System.out.println("valve4 = " + valve4);
		System.out.println("i = " + i);
		System.out.println("f = " + f);
		System.out.println("source = " + source);
	}
}

class Cookie {
	Cookie() {
		System.out.println("Cookie construct");
	}

	void foo() {
		System.out.println("foo");
	}
}

class Garbage {
	static int i;
	static int j;
	static {
		i = 2;
		j = 3;
		System.out.println("i + j = " + i + j);
	}

	int x;
	int y;
	{
		x = 5;
		y = 6;
		System.out.println("x + y = " + x + y);
	}
}

//: Bath.java
//Constructor initialization with composition

class Soap {
	private String s;

	Soap() {
		System.out.println("Soap()");
		s = new String("Constructed");
	}

	public String toString() {
		return s;
	}
}

class Bath {
	private String
	// Initializing at point of definition:
	s1 = new String("Happy"), s2 = "Happy", s3, s4;
	Soap castille;
	int i;
	float toy;

	Bath() {
		System.out.println("Inside Bath()");
		s3 = new String("Joy");
		i = 47;
		toy = 3.14f;
		castille = new Soap();
	}

	void print() {
		if (s4 == null)
			s4 = new String("Joy");
		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);
		System.out.println("s3 = " + s3);
		System.out.println("s4 = " + s4);
		System.out.println("i = " + i);
		System.out.println("toy = " + toy);
		System.out.println("castille = " + castille);
	}
}

class Cleanser {
	private String s = new String("Cleanser");

	public void append(String a) {
		s += a;
	}

	public void dilute() {
		append(" dilute()");
	}

	public void apply() {
		append(" apply()");
	}

	public void scrub() {
		append(" scrub()");
	}

	public void print() {
		System.out.println(s);
	}

	public static void main(String[] args) {
		Cleanser x = new Cleanser();
		x.dilute();
		x.apply();
		x.scrub();
		x.print();
	}
}

class Detergent extends Cleanser {
	public void scrub() {
		append(" Detegent.scrub()");
		super.scrub();
	}

	public void foam() {
		append(" foam()");
	}

	public static void main(String[] args) {
		Detergent x = new Detergent();
		x.dilute();
		x.apply();
		x.scrub();
		x.foam();
		x.print();
		System.out.println("Testing base class:");
		Cleanser.main(args);
	}
}