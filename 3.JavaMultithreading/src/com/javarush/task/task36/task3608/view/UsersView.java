package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

import java.util.StringJoiner;

public class UsersView implements View {

    private Controller controller;

    @Override
    public void refresh(ModelData modelData) {
        StringJoiner result = new StringJoiner("\t");
        result.add("All users:\n");
        modelData.getUsers().forEach(u -> result.add(u.toString() + "\n"));
        System.out.println(result.toString() + "===================================================");

    }

    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
