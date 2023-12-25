package com.javarush.games.minigames.mini05;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Color;

/* 
Цвета радуги
*/

public class RainbowGame extends Game {

    @Override
    public void initialize() {
        setScreenSize(10, 7);
        Color currentColor = Color.WHITE;

        for (int i = 0; i < 7; i++) {
            switch (i) {
                case (0):
                    currentColor = Color.RED;
                    break;
                case (1):
                    currentColor = Color.ORANGE;
                    break;
                case (2):
                    currentColor = Color.YELLOW;
                    break;
                case (3):
                    currentColor = Color.GREEN;
                    break;
                case (4):
                    currentColor = Color.BLUE;
                    break;
                case (5):
                    currentColor = Color.INDIGO;
                    break;
                case (6):
                    currentColor = Color.VIOLET;
                    break;
                default:
                    break;
            }
            for (int j = 0; j < 10; j++) {
                setCellColor(j, i, currentColor);
            }
        }
    }
}
