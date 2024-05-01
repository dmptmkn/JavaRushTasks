package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;


public class Snake extends GameObject {

    public boolean isAlive = true;

    private Direction direction = Direction.LEFT;
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";

    private List<GameObject> snakeParts = new ArrayList<>();

    public Snake(int x, int y) {
        super(x, y);
        for (int i = 0; i < 3; i++) {
            snakeParts.add(new GameObject(x + i, y));
        }
    }

    public void draw(Game game) {
        for (int i = 0; i < snakeParts.size(); i++) {
            GameObject snakePart = snakeParts.get(i);
            String snakeSign = (i != 0) ? BODY_SIGN : HEAD_SIGN;
            Color snakeColor = !isAlive ? Color.RED : Color.BLACK;
            game.setCellValueEx(snakePart.x, snakePart.y, Color.NONE, snakeSign, snakeColor, 75);
        }
    }

    public void setDirection(Direction direction) {
        if (direction != this.direction.getOpposite()) this.direction = direction;
    }

    public void move() {
        GameObject newHead = createNewHead();
        if (newHead.x >= SnakeGame.WIDTH || newHead.x < 0 || newHead.y >= SnakeGame.HEIGHT || newHead.y < 0) {
            isAlive = false;
            return;
        }

        snakeParts.add(0, newHead);
        removeTail();
    }

    public GameObject createNewHead() {
        GameObject head = snakeParts.get(0);
        GameObject newHead = null;
        switch (direction) {
            case UP:
                newHead = new GameObject(head.x, head.y - 1);
                break;
            case DOWN:
                newHead = new GameObject(head.x, head.y + 1);
                break;
            case LEFT:
                newHead = new GameObject(head.x - 1, head.y);
                break;
            case RIGHT:
                newHead = new GameObject(head.x + 1, head.y);
                break;
        }

        return newHead;
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.size() - 1);
    }
}
