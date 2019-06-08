package com.jt;

import java.io.File;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.management.Query;

public class DataStructure {
	public static final Logger logger = Logger.getLogger("com.jt.UnitTest1");
	enum WeekDay {Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday};
	public static void main(String[] args) {
		Unit();
		DataStructure();
	}

	public static void Unit() {
		logger.warning("warning");
		logger.fine("fine");

		String classNameString = "java.util.Scanner";
		try {
			Class<?> class1 = Class.forName(classNameString);
			logger.info(class1.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void DataStructure() {
		Properties properties = new Properties();
		properties.put("width", 200);
		properties.put("title", "Hello World!");
		logger.log(Level.INFO, properties.toString());

		String title = properties.getProperty("header", "New Document");
		logger.log(Level.INFO, title);
		
		String system = System.getProperties().get("user.dir").toString();
		logger.log(Level.INFO, system);

		EnumMap<WeekDay, String> personInCharg = new EnumMap<>(WeekDay.class);
		personInCharg.put(WeekDay.Monday, "Fred");
		logger.log(Level.INFO, personInCharg.toString());
		
		ArrayDeque<String> stack = new ArrayDeque<String>();
		stack.push("Peter");
		stack.push("Paul");
		stack.push("Mary");
		while (!stack.isEmpty()) {
			logger.log(Level.INFO, stack.pop());
		}
		
		Queue<String> queue = new ArrayDeque<String>();
		queue.add("Peter");
		queue.add("Paul");
		queue.add("Mary");
		while (!queue.isEmpty()) {
			logger.log(Level.INFO, queue.remove());
		}
		
		//Only used above java9
//		List<String> names = List.of("Peter", "Paul", "Mary");
//		Set<String> numbers = Set.of(2, 3, 5);
//		Map<String, Integer> scores = Map.of("Peter", 2, "Paul", 3, "Mary", 5);
	}
}
