package com.javarush.games.snake;

import com.javarush.engine.cell.*;

public class SnakeGame extends Game {

    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private static final int GOAL = 28;

    private Snake snake;
    private Apple apple;
    private int score;
    private boolean isGameStopped;
    private int turnDelay;

    @Override
    public void initialize() {
        setScreenSize(HEIGHT, WIDTH);
        createGame();
    }

    private void createGame() {
        turnDelay = 300;
        setTurnTimer(turnDelay);
        isGameStopped = false;
        score = 0;
        setScore(score);

        snake = new Snake(WIDTH / 2, HEIGHT / 2);
        createNewApple();

        drawScene();
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

    private void createNewApple() {
        Apple newApple;
        do {
            int x = getRandomNumber(WIDTH);
            int y = getRandomNumber(HEIGHT);
            newApple = new Apple(x, y);
        } while (snake.checkCollision(newApple));
        apple = newApple;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.SPACE && isGameStopped) {
            createGame();
        } else if (key == Key.LEFT) {
            snake.setDirection(Direction.LEFT);
        } else if (key == Key.RIGHT) {
            snake.setDirection(Direction.RIGHT);
        } else if (key == Key.UP) {
            snake.setDirection(Direction.UP);
        } else if (key == Key.DOWN) {
            snake.setDirection(Direction.DOWN);
        }
    }

    @Override
    public void onTurn(int i) {
        snake.move(apple);

        if (!apple.isAlive) {
            createNewApple();

            score += 5;
            setScore(score);

            turnDelay -= 10;
            setTurnTimer(turnDelay);
        }
        if (!snake.isAlive) gameOver();
        if (snake.getLength() > GOAL) win();

        drawScene();
    }

    private void win() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.NONE, "YOU WIN", Color.GREEN, 75);
    }

    private void gameOver() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.NONE, "GAME OVER", Color.RED, 75);
    }
}
