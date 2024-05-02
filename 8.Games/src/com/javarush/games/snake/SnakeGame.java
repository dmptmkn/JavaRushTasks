package com.javarush.games.snake;

import com.javarush.engine.cell.*;

public class SnakeGame extends Game {

    private Snake snake;
    private Apple apple;

    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;

    private int turnDelay;

    private boolean isGameStopped;

    @Override
    public void initialize() {
        setScreenSize(HEIGHT, WIDTH);
        createGame();
    }

    private void drawScene() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellValueEx(x, y, Color.DARKSEAGREEN, "");
            }
        }
        snake.draw(this);
        apple.draw(this);
    }

    private void createGame() {
        this.snake = new Snake(WIDTH / 2, HEIGHT / 2);
        createNewApple();
        this.turnDelay = 300;
        setTurnTimer(turnDelay);
        isGameStopped = false;
        drawScene();
    }

    private void gameOver() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "GAME OVER", Color.RED, 75);
    }

    private void createNewApple() {
        this.apple = new Apple(getRandomNumber(WIDTH), getRandomNumber(HEIGHT));
    }

    @Override
    public void onTurn(int n) {
        snake.move(apple);
        if (!apple.isAlive) createNewApple();
        if (!snake.isAlive) gameOver();
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.LEFT) {
            snake.setDirection(Direction.LEFT);
        } else if (key == Key.RIGHT) {
            snake.setDirection(Direction.RIGHT);
        } else if (key == Key.UP) {
            snake.setDirection(Direction.UP);
        } else if (key == Key.DOWN) {
            snake.setDirection(Direction.DOWN);
        }
    }
}
