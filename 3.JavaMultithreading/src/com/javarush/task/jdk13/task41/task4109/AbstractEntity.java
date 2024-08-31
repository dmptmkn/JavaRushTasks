package com.javarush.task.jdk13.task41.task4109;

import java.util.Date;

public abstract class AbstractEntity {

    public int id;
    public Date createdTime;
    public Date updatedTime;

    protected AbstractEntity() {
    }

    protected AbstractEntity(AbstractEntity entity) {
        this.id = entity.id;
        this.createdTime = entity.createdTime;
        this.updatedTime = entity.updatedTime;
    }

    public abstract Object clone();
}
