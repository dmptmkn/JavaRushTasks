package com.javarush.task.task24.task2413;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class Ball extends BaseObject {

    private double speed;
    private double direction;
    private double dx;
    private double dy;
    private boolean isFrozen;

    public Ball(double x, double y, double speed, double direction) {
        super(x, y, 1);
        this.speed = speed;
        this.direction = direction;
        this.dx = x;
        this.dy = y;
        this.isFrozen = true;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
        double angle = Math.toRadians(direction);
        dx = Math.cos(angle) * speed;
        dy = -Math.sin(angle) * speed;
    }

    void checkRebound(int minx, int maxx, int miny, int maxy) {

    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public Ball(double x, double y, double radius) {
        super(x, y, radius);
    }

    @Override
    void draw(Canvas canvas) {
        canvas.setPoint(super.x, super.y, 'O');
    }

    @Override
    void move() {
        if (isFrozen) return;
        super.x += dx;
        super.y += dy;
    }

    void start() {
        isFrozen = false;
    }
}
