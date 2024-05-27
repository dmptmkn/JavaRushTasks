package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize = 0;
    private int maxSize = Integer.MAX_VALUE;

    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length

        boolean isPartOfName = true;
        if (partOfName != null && !file.getFileName().toString().contains(partOfName))
            isPartOfName = false;

        boolean isPartOfContent = true;
        String contentString = new String(content);
        if (partOfContent != null && !contentString.contains(partOfContent))
            isPartOfContent = false;

        boolean isGreaterThanMin = true;
        if (minSize > 0 && content.length < minSize)
            isGreaterThanMin = false;

        boolean isLessThanMax = true;
        if (maxSize < Integer.MAX_VALUE && content.length > maxSize)
            isLessThanMax = false;

        if (isPartOfName && isPartOfContent && isGreaterThanMin && isLessThanMax)
            foundFiles.add(file);

        return super.visitFile(file, attrs);
    }

    public String getPartOfName() {
        return partOfName;
    }

    public String getPartOfContent() {
        return partOfContent;
    }

    public int getMinSize() {
        return minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
}
