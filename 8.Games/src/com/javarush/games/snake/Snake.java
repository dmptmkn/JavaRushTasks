package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;


public class Snake extends GameObject {

    private List<GameObject> snakeParts = new ArrayList<>();

    public Snake(int x, int y) {
        super(x, y);
        for (int i = 0; i < 3; i++) {
            snakeParts.add(new GameObject(x + i, y));
        }
    }
}
