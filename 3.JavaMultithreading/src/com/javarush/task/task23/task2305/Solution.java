package com.javarush.task.task23.task2305;

/* 
Inner
*/

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution solution1 = new Solution();
        InnerClass solution1inner1 = solution1. new InnerClass();
        InnerClass solution1inner2 = solution1. new InnerClass();
        solution1.innerClasses[0] = solution1inner1;
        solution1.innerClasses[1] = solution1inner2;

        Solution solution2 = new Solution();
        InnerClass solution2inner1 = solution2. new InnerClass();
        InnerClass solution2inner2 = solution2. new InnerClass();
        solution2.innerClasses[0] = solution2inner1;
        solution2.innerClasses[1] = solution2inner2;

        return new Solution[] {solution1, solution2};
    }

    public static void main(String[] args) {

    }
}
