package com.javarush.task.jdk13.task43.task4306;

/* 
В поиске ботана
*/

//import org.apache.commons.lang3.ObjectUtils;

import org.apache.commons.lang3.ObjectUtils;

public class Solution {

    public static void main(String[] args) {
        Student studentOne = new Student("Joe",10, 8, 7, 7, 5, 6, 9);
        Student studentTwo = new Student("Jane",8, 9, 5, 6, 7, 7, 8);

        String result = compareStudentGrades(studentOne, studentTwo);
        System.out.println(result);
    }

    public static String compareStudentGrades(Student studentOne, Student studentTwo) {
        if (ObjectUtils.isEmpty(studentOne) || ObjectUtils.isEmpty(studentTwo)) return "Make sure there are no null objects";

        int compareResult = 0;
        compareResult += ObjectUtils.compare(studentOne.getMathScore(), studentTwo.getMathScore());
        compareResult += ObjectUtils.compare(studentOne.getPhysicsScore(), studentTwo.getPhysicsScore());
        compareResult += ObjectUtils.compare(studentOne.getChemistryScore(), studentTwo.getChemistryScore());
        compareResult += ObjectUtils.compare(studentOne.getBiologyScore(), studentTwo.getBiologyScore());
        compareResult += ObjectUtils.compare(studentOne.getGeographyScore(), studentTwo.getGeographyScore());
        compareResult += ObjectUtils.compare(studentOne.getHistoryScore(), studentTwo.getHistoryScore());
        compareResult += ObjectUtils.compare(studentOne.getEnglishScore(), studentTwo.getEnglishScore());

        String compareMessage;
        if (compareResult > 0) {
            compareMessage = studentOne.getName() + " has a higher grades score";
        } else if (compareResult < 0) {
            compareMessage = studentTwo.getName() + " has a higher grades score";
        } else {
            compareMessage = "Student grades scores are equal";
        }

        return compareMessage;
    }
}


