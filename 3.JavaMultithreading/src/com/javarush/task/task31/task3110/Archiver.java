package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {

    public static void main(String[] args) {
        String filePath = null;
        String archivePath = null;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите полный путь до архива:");
            filePath = console.readLine();
            System.out.println("Введите путь к файлу для архивации:");
            archivePath = console.readLine();
        } catch (Exception e) {
        }

        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(filePath));
        try {
            zipFileManager.createZip(Paths.get(archivePath));
        } catch (Exception e) {
        }
    }
}