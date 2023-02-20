package com.linc;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

public class Triangle implements InitializingBean, DisposableBean {
    private List<Point> points;

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public void draw() {
        for (Point point : this.points) {
            System.out.println("Point = (" + point.getX() + ", " + point.getY() + ")");
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean init method call for Triangle");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean destroy method call for Triangle");
    }

    public void myInit() {
        System.out.println("My init method call for Triangle");
    }

    public void myDestroy() {
        System.out.println("My destroy method call for Triangle");
    }
}
