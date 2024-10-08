package com.javarush.task.jdk13.task41.task4104;

/* 
Фантастические твари
*/

import com.javarush.task.jdk13.task41.task4104.creature.Cow;
import com.javarush.task.jdk13.task41.task4104.move.Fly;
import com.javarush.task.jdk13.task41.task4104.sound.Meow;

public class Solution {

    public static void main(String[] args) {
        Cow cow = new Cow(new Fly(), new Meow());
        cow.howDoIMove();
        cow.howDoISound();
    }
}
