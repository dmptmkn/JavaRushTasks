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
