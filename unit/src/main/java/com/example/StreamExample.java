package com.example;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;

public class StreamExample {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./example.zip");
        Path file = Paths.get("./example.zip/file");
        try {
            Files.createDirectories(path);
//            Files.createFile(file);


        } catch (IOException e) {
            e.printStackTrace();
        }

        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            public FileVisitResult postVisitDirectory(Path dir, IOException ex) throws IOException {
                if (ex != null) throw ex;
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
