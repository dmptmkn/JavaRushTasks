package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipRemoveCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Удаление файла.");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Введите, из какого архива и какой файл вы хотите удалить:");
            Path deletePath = Paths.get(ConsoleHelper.readString());
            zipFileManager.removeFile(deletePath);

            ConsoleHelper.writeMessage("Файл удален.");
        } catch (WrongZipFileException e) {
            ConsoleHelper.writeMessage("Неверный путь для удаления.");
        }
    }
}
