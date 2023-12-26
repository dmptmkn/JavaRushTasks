package com.javarush.task.pro.task09.task0908;

import java.util.Objects;
import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution {

    public static String[] hexStatic = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    public static String[] binStatic = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        if (binaryNumber == null || binaryNumber.length() == 0 ||
                !binaryNumber.matches("[0,1]+")) {
            return "";
        } else {
            int a = (binaryNumber.length() % 4);
            if (a != 0) {
                a = 4 - binaryNumber.length() % 4;
            }
            String[] arrayBinaryNumber = binaryNumber.split("");
            String[] copiedArrayBinaryNumber = new String[binaryNumber.length() + a];
            String[] binaryArray = new String[copiedArrayBinaryNumber.length / 4];
            System.arraycopy(arrayBinaryNumber, 0, copiedArrayBinaryNumber,
                    a, arrayBinaryNumber.length);

            for (int i = 0; i < a; i++) {
                copiedArrayBinaryNumber[i] = "0";
            }

            for (int i = 0; i < copiedArrayBinaryNumber.length - 1; i += 4) {
                binaryArray[i / 4] =
                        copiedArrayBinaryNumber[i] + copiedArrayBinaryNumber[i + 1] +
                                copiedArrayBinaryNumber[i + 2] + copiedArrayBinaryNumber[i + 3];
            }

            for (int i = 0; i < binStatic.length; i++) {
                for (int j = binaryArray.length - 1; j >= 0; j--) {
                    if (Objects.equals(binaryArray[j], binStatic[i])) {
                        binaryArray[j] = hexStatic[i];
                    }
                }
            }
            return String.join("", binaryArray);
        }
    }

    public static String toBinary(String hexNumber) {
        if (hexNumber == null || hexNumber.length() == 0 ||
                !hexNumber.matches("[0-9,a-f]+")) {
            return "";
        } else {
            String[] arrayHexNumber = hexNumber.split("");
            for (int i = 0; i < binStatic.length; i++) {
                for (int j = 0; j < arrayHexNumber.length; j++) {
                    if (Objects.equals(arrayHexNumber[j], hexStatic[i])) {
                        arrayHexNumber[j] = binStatic[i];
                    }
                }
            }
            return String.join("", arrayHexNumber);
        }
    }
}
