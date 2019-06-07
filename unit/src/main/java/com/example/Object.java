package com.example;

public class Object {
	private int id;
	public final boolean equals (Object obj) {
		// compare two object equals
		if (this == obj) return true;
		if (!(obj instanceof Object)) return false;

		Object other = (Object)obj;
		return id == other.id;
		
	}

	public static void main(String[] args) {
		System.out.println(System.out);

	}
}
