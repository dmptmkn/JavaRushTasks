package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

import java.util.StringJoiner;

public class EditUserView implements View {

    private Controller controller;

    @Override
    public void refresh(ModelData modelData) {
        StringJoiner result = new StringJoiner("\t");
        result.add("User to be edited:\n");
        result.add(modelData.getActiveUser().toString() + "\n");
        System.out.println(result.toString() + "===================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
