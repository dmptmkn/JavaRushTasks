package com.javarush.task.task32.task3209;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MenuHelper {

    public static JMenuItem addMenuItem(JMenu parent, String text, ActionListener actionListener) {
        JMenuItem newItem = new JMenuItem(text);
        newItem.addActionListener(actionListener);
        parent.add(newItem);
        return newItem;
    }

    public static JMenuItem addMenuItem(JMenu parent, Action action) {
        JMenuItem newItem = new JMenuItem(action);
        parent.add(newItem);
        return newItem;
    }

    public static JMenuItem addMenuItem(JMenu parent, String text, Action action) {
        JMenuItem newItem = addMenuItem(parent, action);
        newItem.setText(text);
        return newItem;
    }

    public static void initHelpMenu(View view, JMenuBar menuBar) {
    }

    public static void initFontMenu(View view, JMenuBar menuBar) {
    }

    public static void initColorMenu(View view, JMenuBar menuBar) {
    }

    public static void initAlignMenu(View view, JMenuBar menuBar) {
    }

    public static void initStyleMenu(View view, JMenuBar menuBar) {
    }

    public static void initEditMenu(View view, JMenuBar menuBar) {
    }

    public static void initFileMenu(View view, JMenuBar menuBar) {
    }

}
