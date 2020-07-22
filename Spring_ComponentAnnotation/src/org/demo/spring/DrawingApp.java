package org.demo.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		//Triangle triangle = (Triangle) context.getBean("triangle");
		context.registerShutdownHook();
		Shape shape = (Circle) context.getBean("circle");
		shape.draw();
		
	}
	
}
