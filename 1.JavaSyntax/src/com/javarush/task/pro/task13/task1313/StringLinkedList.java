package com.javarush.task.pro.task13.task1313;

public class StringLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public void add(String value) {
        Node newElement = new Node();
        newElement.value = value;
        if (last.prev == null) {
            first.next = newElement;
            last.prev = newElement;
            newElement.prev = first;
        } else {
            last.prev.next = newElement;
            newElement.prev = last.prev;
            last.prev = newElement;
        }
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
