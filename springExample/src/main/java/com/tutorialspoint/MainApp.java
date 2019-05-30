package com.tutorialspoint;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

//		HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
//		helloWorld.getMessage1();
//		helloWorld.getMessage2();
//
//		HelloIndia helloIndia = (HelloIndia) context.getBean("helloIndia");
//		helloIndia.getMessage1();
//		helloIndia.getMessage2();
//		helloIndia.getMessage3();
//
//		JavaCollection javaCollection = (JavaCollection) context.getBean("javaCollection");
//		javaCollection.getAddressList();
//		javaCollection.getAddressSet();
//		javaCollection.getAddressMap();
//		javaCollection.getAddressProp();
		
		TextEditor textEditor = (TextEditor) context.getBean("textEditor");
		textEditor.spellCheck();
	}
}