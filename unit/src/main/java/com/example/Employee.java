package com.example;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;
import java.util.function.IntConsumer;

public class Employee implements Person, Identified {
	private static final Random generator = new Random();
	private int id;
	public Employee() {
		id = 1 + generator.nextInt(1_000_000);
	}
	public static void repeat(int n, Runnable action) {
		for(int i = 0; i < n; i++ )
			action.run();
	}
	public static void repeat(int n, IntConsumer action) {
		for(int i = 0; i < n; i++)
			action.accept(i);
	}
	public static BufferedImage createImage (int width, int height, PixelFunction f) {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				Color color = f.apply(x, y);
				image.setRGB(x, y, color.getRGB());
			}
		}
		return image;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++)
			System.out.println(new Employee().id);
		repeat(10, ()->{ System.out.println("Hello  World"); });
		repeat(10, i->System.out.println("IntConsumer " + (9-i)));
		
		String[] word = {"a", "ab", "abc"};
		Arrays.sort(word, (first, second) -> second.length() - first.length() );
		repeat(3, i->System.out.println("Word " + i + ": " + word[i]));
		
		BufferedImage frenchFlag = createImage(150, 100, (x, y) -> x < 50 ? Color.BLUE : x < 100 ? Color.WHITE : Color.RED);
		
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getAge() {
		// TODO Auto-generated method stub
		return null;
	}
	public int GetId() {
		return Person.super.GetId();
	}
}

interface PixelFunction {
	Color apply (int x, int y);
}
interface Person {
	String getAge();
	default int GetId() {return 0;};
}
interface Identified {
	String getName();
	default int GetId() {return 0;}
}