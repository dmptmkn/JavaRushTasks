package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake extends GameObject {

    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";

    private List<GameObject> snakeParts = new ArrayList<>();
    private Direction direction = Direction.LEFT;
    public boolean isAlive = true;

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

    public void move(Apple apple) {
        GameObject newHead = createNewHead();

        if (checkCollision(newHead)) {
            isAlive = false;
            return;
        }

        snakeParts.add(0, newHead);

        if (newHead.x == apple.x && newHead.y == apple.y) {
            apple.isAlive = false;
            return;
        }

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

    public boolean checkCollision(GameObject newObject) {
        for (GameObject nextPart : snakeParts) {
            if (nextPart.x == newObject.x && nextPart.y == newObject.y) return true;
        }

        return false;
    }

    public void setDirection(Direction direction) {
        if ((this.direction == Direction.LEFT && isSameX()) || (this.direction == Direction.RIGHT && isSameX()))
            return;
        else if ((this.direction == Direction.UP && isSameY()) || (this.direction == Direction.DOWN && isSameY()))
            return;

        if (direction != this.direction.getOpposite()) this.direction = direction;
    }

    public int getLength() {
        return snakeParts.size();
    }

    private boolean isSameX() {
        return snakeParts.get(0).x == snakeParts.get(1).x;
    }

    private boolean isSameY() {
        return snakeParts.get(0).y == snakeParts.get(1).y;
    }
}
