package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        AtomicInteger fileCount = new AtomicInteger(0);
        AtomicInteger directoryCount = new AtomicInteger(0);
        AtomicLong totalSizeCount = new AtomicLong(0);

        String pathString;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            pathString = console.readLine();
        }
        Path path = Paths.get(pathString);

        if (Files.isRegularFile(path)) {
            System.out.println(path.toAbsolutePath() + "  - не папка");
            return;
        }

        FileVisitor<Path> fileVisitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                if (!dir.equals(path)) directoryCount.incrementAndGet();
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Objects.requireNonNull(file);
                Objects.requireNonNull(attrs);

                if (Files.isDirectory(file)) {
                    directoryCount.incrementAndGet();
                } else {
                    fileCount.incrementAndGet();

                    int byteSize = Files.readAllBytes(file).length;
                    totalSizeCount.addAndGet(byteSize);
                }

                return FileVisitResult.CONTINUE;
            }
        };

        Files.walkFileTree(path, fileVisitor);

        System.out.println("Всего папок - " + directoryCount);
        System.out.println("Всего файлов - " + fileCount);
        System.out.println("Общий размер - " + totalSizeCount);
    }
}
