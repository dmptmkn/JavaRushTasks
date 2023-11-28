package com.javarush.task.pro.task15.task1520;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Перемещение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path sourceDirectory = Path.of(scanner.nextLine());
        Path targetDirectory = Path.of(scanner.nextLine());

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(sourceDirectory)) {
            for (Path entry : stream) {
                if (Files.isRegularFile(entry)) {
                    Files.move(entry, targetDirectory.resolve(entry.getFileName()));
                } else if (Files.isDirectory(entry)) {
                }
            }
        } catch (DirectoryIteratorException e) {
            throw e.getCause();
        }
    }
}

