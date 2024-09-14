package com.javarush.task.jdk13.task41.task4123;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.util.Objects.isNull;

public class UserDB {

    private volatile Map<Integer, User> users;

    private void initDB() throws Exception {
        synchronized (this) {
            if (isNull(users)) {
                if (isNull(users)) {
                    HashMap<Integer, User> localUsers = new HashMap<>();
                    for (int i = 0; i < 100; i++) {
                        localUsers.put(i, new User(i, "user" + i));
                        TimeUnit.MILLISECONDS.sleep(1);
                    }
                    users = localUsers;
                }
            }
        }
    }

    public Map<Integer, User> getDB() throws Exception {
        initDB();
        return users;
    }
}
