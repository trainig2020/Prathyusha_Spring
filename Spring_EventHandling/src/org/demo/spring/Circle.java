package org.demo.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

//@Component
//@Service
@Controller

public class Circle implements Shape, ApplicationEventPublisherAware {

	private Point center;
	
	private ApplicationEventPublisher publisher;
	
	
	@Autowired
	private MessageSource messageSource;
	
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public Point getCenter() {
		return center;
	}

   

	@Override
	public void draw() {
		System.out.println(this.messageSource.getMessage("drawing.circle", null,"Default Drawing Message", null));
		System.out.println(this.messageSource.getMessage("drawing.point", new Object[] {center.getX(),center.getY()},"Default Point Message", null));
		DrawEvent drawEvent =new DrawEvent(this);
		publisher.publishEvent(drawEvent);
		
	}
	
	 @Resource
		public void setCenter(Point center) {
			this.center = center;
		}

	
	@PostConstruct
	public void initializeCircle(){
		System.out.println("Init of Circle");
	}
	
	@PreDestroy
	public void destroyCircle(){
		System.out.println("Destroy of Circle");
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		
		this.publisher= publisher;
	}

}
