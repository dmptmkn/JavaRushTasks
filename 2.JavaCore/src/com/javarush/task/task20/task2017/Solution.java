package com.javarush.task.task20.task2017;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/

public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) throws IOException {
        A a = new A();
        try {
            if (objectStream.readObject() instanceof A) {
                a = (A) objectStream.readObject();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return a;
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
