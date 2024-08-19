package com.javarush.task.jdk13.task41.task4105;

import com.javarush.task.jdk13.task41.task4105.facade.PotionConvertionFacade;

/* 
Алхимическая библиотека
*/

public class Solution {

    public static String potionName = "Minor Healing Potion";
    public static String type = "stamina";

    public static void main(String[] args) {
        PotionConvertionFacade potionConvertionFacade = new PotionConvertionFacade();
        String result = potionConvertionFacade.convertPotion(potionName, type);
        System.out.println(result);
    }
}
