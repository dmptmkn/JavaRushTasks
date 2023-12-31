package com.javarush.task.pro.task08.task0805;

import java.util.Random;

public class MagicBall {
    private static final String CERTAIN = "Бесспорно";
    private static final String DEFINITELY = "Определённо да";
    private static final String MOST_LIKELY = "Вероятнее всего";
    private static final String OUTLOOK_GOOD = "Хорошие перспективы";
    private static final String ASK_AGAIN_LATER = "Спроси позже";
    private static final String TRY_AGAIN = "Попробуй снова";
    private static final String NO = "Мой ответ — нет";
    private static final String VERY_DOUBTFUL = "Весьма сомнительно";

    public static String getPrediction() {
        Random random = new Random();
        int answer = random.nextInt(8);
        String oracle = null;

        switch (answer) {
            case (0):
                oracle = CERTAIN;
                break;
            case (1):
                oracle = DEFINITELY;
                break;
            case (2):
                oracle = MOST_LIKELY;
                break;
            case (3):
                oracle = OUTLOOK_GOOD;
                break;
            case (4):
                oracle = ASK_AGAIN_LATER;
                break;
            case (5):
                oracle = TRY_AGAIN;
                break;
            case (6):
                oracle = NO;
                break;
            case (7):
                oracle = VERY_DOUBTFUL;
                break;
            default:
                break;
        }
        return oracle;
    }
}
