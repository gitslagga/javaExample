package top.slagga;

public class Upcasting {
	public static void tune(Wind2 i) {
		i.play(Note2.middleC);
	}

	public static void tune(Stringed2 i) {
		i.play(Note2.middleC);
	}

	public static void tune(Brass2 i) {
		i.play(Note2.middleC);
	}

	// Doesn't care about type, so new types
	// added to the system still work right:
	public static void tune(Instrument3 i) {
		// ...
		i.play();
	}

	public static void tuneAll(Instrument3[] e) {
		for (int i = 0; i < e.length; i++)
			tune(e[i]);
	}
	
	public static void tune(InstrumentX i) {
		i.play(NoteX.MIDDLE_C);
	}

	public static void main(String[] args) {
//		Wind2 flute = new Wind2();
//		Stringed2 violin = new Stringed2();
//		Brass2 frencHorn = new Brass2();
//		tune(flute);
//		tune(violin);
//		tune(frencHorn);

//		Instrument3[] orchestra = new Instrument3[5];
//		int i = 0;
//		// Upcasting during addition to the array:
//		orchestra[i++] = new Wind3();
//		orchestra[i++] = new Percussion3();
//		orchestra[i++] = new Stringed3();
//		orchestra[i++] = new Brass3();
//		orchestra[i++] = new Woodwind3();
//		tuneAll(orchestra);
		
		WindX flute = new WindX();
		tune(flute);	// Not the desired behavior!
	}
}

//: WindError.java
// Accidentally changing the interface
class NoteX {
	public static final int 
		MIDDLE_C = 0, C_SHARP = 1, C_FLAT = 2;
}
class InstrumentX {
	public void play(int NoteX) {
		System.out.println("InstrumentX.play()");
	}
}
class WindX extends InstrumentX {
	// OOPS! Changes the method interface:
	public void play(NoteX n) {
		System.out.println("WindX.play(NoteX n)");
	}
}

class Instrument3 {
	public void play() {
		System.out.println("Instrument3.play()");
	}

	public String what() {
		return "Instrument3";
	}

	public void adjust() {
	}
}

class Wind3 extends Instrument3 {
	public void play() {
		System.out.println("Wind3.play()");
	}

	public String what() {
		return "Wind3";
	}

	public void adjust() {
	}
}

class Percussion3 extends Instrument3 {
	public void play() {
		System.out.println("Percussion3.play()");
	}

	public String what() {
		return "Percussion3";
	}

	public void adjust() {
	}
}

class Stringed3 extends Instrument3 {
	public void play() {
		System.out.println("Stringed3.play()");
	}

	public String what() {
		return "Stringed3";
	}

	public void adjust() {
	}
}

class Brass3 extends Wind3 {
	public void play() {
		System.out.println("Brass3.play()");
	}

	public void adjust() {
		System.out.println("Brass3.adjust()");
	}
}

class Woodwind3 extends Wind3 {
	public void play() {
		System.out.println("Woodwind3.play()");
	}

	public String what() {
		return "Woodwind3";
	}
}

class Note2 {
	private int value;

	private Note2(int val) {
		value = val;
	}

	public static final Note2 middleC = new Note2(0), cSharp = new Note2(1), cFlat = new Note2(2);
}

class Instrument2 {
	public void play(Note2 n) {
		System.out.println("Instrument2.play()");
	}
}

class Wind2 extends Instrument2 {
	public void play(Note2 n) {
		System.out.println("Wind2.paly()");
	}
}

class Stringed2 extends Instrument2 {
	public void play(Note2 n) {
		System.out.println("Stringd2.play()");
	}
}

class Brass2 extends Instrument2 {
	public void play(Note2 n) {
		System.out.println("Brass2.play()");
	}
}