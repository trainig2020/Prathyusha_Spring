package org.demo.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
     	Shape shape = (Shape) context.getBean("circle");
		shape.draw();
		//System.out.println(context.getMessage("greeting", null,"Default Greeting", null));
		
		
	}
	
}