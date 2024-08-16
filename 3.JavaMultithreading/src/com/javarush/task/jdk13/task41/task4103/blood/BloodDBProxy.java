package com.javarush.task.jdk13.task41.task4103.blood;

import com.javarush.task.jdk13.task41.task4103.security.SecuritySystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class BloodDBProxy implements DB {

    private final SecuritySystem security = new SecuritySystem();
    private BloodDB db;
    private final BloodSample denied = new BloodSample(0, "access", "denied", null, null, null);

    public BloodDBProxy() {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            String login = console.readLine();
            String password = console.readLine();
            security.authorize(login, password);
            if (security.isAuthorized()) {
                db = new BloodDB();
            }
        } catch (IOException ignore) {
        }
    }

    @Override
    public BloodSample getById(int id) {
        if (security.isAuthorized()) {
            return db.getById(id);
        }
        return denied;
    }

    @Override
    public List<BloodSample> find(String request) {
        if (security.isAuthorized()) {
            return db.find(request);
        }
        return List.of(denied);
    }
}
