package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File rootFile = new File(root);

        Queue<File> fileQueue = new LinkedList<>();
        if (rootFile.isDirectory()) fileQueue.add(rootFile);

        List<String> fileList = new ArrayList<>();
        File nextInQueue = null;
        while (!fileQueue.isEmpty()) {
            nextInQueue = fileQueue.poll();
            for (File nextFile : nextInQueue.listFiles()) {
                if (nextFile.isDirectory()) {
                    fileQueue.add(nextFile);
                } else {
                    fileList.add(nextFile.getAbsolutePath());
                }
            }
        }

        return fileList;
    }

    public static void main(String[] args) {

    }
}
