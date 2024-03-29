package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;

    public Snake(int x, int y) {
        SnakeSection head = new SnakeSection(x, y);
        sections = new ArrayList<>();
        sections.add(head);
        isAlive = true;
    }

    public int getX() {
        return sections.get(0).getX();
    }

    public int getY() {
        return sections.get(0).getY();
    }

    public void move() {
        if (!isAlive()) {
            return;
        }
        switch (direction) {
            case UP:
                move(0, -1);
                break;
            case RIGHT:
                move(1, 0);
                break;
            case DOWN:
                move(0, 1);
                break;
            case LEFT:
                move(-1, 0);
                break;
        }
    }

    public void move(int dx, int dy) {
        SnakeSection head = sections.get(0);
        checkBorders(head);
        checkBody(head);
        SnakeSection newHead = new SnakeSection(head.getX() + dx, head.getY() + dy);
        sections.add(0, newHead);
        if (sections.get(0).getX() == Room.game.getMouse().getX() && sections.get(0).getY() == Room.game.getMouse().getY()) {
            Room.game.eatMouse();
        } else {
            sections.remove(sections.size() - 1);
        }
    }

    public void checkBorders(SnakeSection head) {
        if (((head.getX() < 0) || (head.getX() >= Room.game.getWidth())) || ((head.getY() < 0) || (head.getY() >= Room.game.getHeight()))) {
            isAlive = false;
        }
    }

    public void checkBody(SnakeSection head) {
        isAlive = !sections.contains(head);
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    private SnakeDirection direction;

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }
}
