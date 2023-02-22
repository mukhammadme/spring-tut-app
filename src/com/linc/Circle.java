package com.linc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component
public class Circle implements Shape {
    private Point center;
    @Autowired
    private MessageSource messageSource;

    public Point getCenter() {
        return center;
    }

    @Resource(name = "pointC")
    public void setCenter(Point center) {
        this.center = center;
    }

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public void draw() {
        System.out.println(this.messageSource.getMessage("drawing.circle", null, "Default Drawing Message", null));
        System.out.println(this.messageSource.getMessage("drawing.point", new Object[]{this.center.getX(), this.center.getY()}, "Default Point Message", null));
//        System.out.println(this.messageSource.getMessage("greeting", null, "Default Greeting", null));
    }

    @PostConstruct
    public void initializeCircle() {
        System.out.println("Circle initialization method");
    }

    @PreDestroy
    public void destroyCircle() {
        System.out.println("Circle destroy method");
    }
}
