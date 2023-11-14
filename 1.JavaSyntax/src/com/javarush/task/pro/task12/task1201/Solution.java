package com.javarush.task.pro.task12.task1201;

/* 
Автоупаковка
*/

public class Solution {
    byte byteValue = 2;
    short shortValue = 3;
    int intValue = 124;
    long longValue = 612435L;
    float floatValue = 32.023F;
    double doubleValue = 12.11;

    char charValue = 'a';
    boolean booleanValue = false;

    Byte byteValueBox = Byte.valueOf(byteValue);
    Short shortValueBox = Short.valueOf(shortValue);
    Integer integerValueBox = Integer.valueOf(intValue);
    Long longValueBox = Long.valueOf(longValue);
    Float floatValueBox = Float.valueOf(floatValue);
    Double doubleValueBox = Double.valueOf(doubleValue);
    Character characterValueBox = Character.valueOf(charValue);
    Boolean booleanValueBox = Boolean.valueOf(booleanValue);


}
