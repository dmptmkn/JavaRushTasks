package com.javarush.task.jdk13.task41.task4104.creature;

import com.javarush.task.jdk13.task41.task4104.move.MoveLogic;
import com.javarush.task.jdk13.task41.task4104.sound.SoundLogic;

public abstract class Creature {

    protected MoveLogic moveLogic;
    protected SoundLogic soundLogic;

    public Creature(MoveLogic moveLogic, SoundLogic soundLogic) {
        this.moveLogic = moveLogic;
        this.soundLogic = soundLogic;
    }

    abstract String getName();

    void howDoIMove() {
        moveLogic.move(getName());
    }

    void howDoISound() {
        soundLogic.sound(getName());
    }
}
