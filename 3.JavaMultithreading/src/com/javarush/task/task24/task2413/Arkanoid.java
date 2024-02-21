package com.javarush.task.task24.task2413;

import java.util.Iterator;
import java.util.List;

public class Arkanoid {

    private int width;
    private int height;

    private boolean isGameOver;

    private Ball ball;
    private Stand stand;
    private List<Brick> bricks;

    static Arkanoid game;

    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static void main(String[] args) {

    }

    void run() {

    }

    void move() {
        ball.move();
        stand.move();
    }

    void draw(Canvas canvas) {
        ball.draw(canvas);
        stand.draw(canvas);
        for (Brick aBrick : bricks) {
            aBrick.draw(canvas);
        }
    }

    public void checkBricksBump() {
        double angle = Math.random() * 360;

        Iterator<Brick> brickIterator = bricks.iterator();
        Brick nextBrick = null;
        while (brickIterator.hasNext()) {
            nextBrick = brickIterator.next();
            if (ball.intersects(nextBrick)) {
                ball.setDirection(angle);
                brickIterator.remove();
            }
        }
    }

    public void checkStandBump() {
        double angle = 90 + 20 * (Math.random() - 0.5);

        if (ball.intersects(stand)) {
            ball.setDirection(angle);
        }

    }

    public void checkEndGame() {
        if (ball.getY() > height) isGameOver = true;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public List<Brick> getBricks() {
        return bricks;
    }

    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }
}
