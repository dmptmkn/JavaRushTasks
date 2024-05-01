package com.javarush.games.snake;

public enum Direction {
    UP, DOWN, RIGHT, LEFT;

    private Direction opposite;

    public Direction getOpposite() {
        return opposite;
    }

    static {
        UP.opposite = DOWN;
        DOWN.opposite = UP;
        RIGHT.opposite = LEFT;
        LEFT.opposite = RIGHT;
    }
}
