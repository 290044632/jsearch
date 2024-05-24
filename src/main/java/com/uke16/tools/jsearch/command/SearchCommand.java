package com.uke16.tools.jsearch.command;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Optional;

public class SearchCommand implements ICommand {
    @Override
    public String getName() {
        return "s";
    }

    @Override
    public void execute(IOptions options) {
        String dirPath = Optional.ofNullable(options.getValue("dir"))
                .map(Object::toString)
                .orElseGet(() -> ".");
        String syntax = Optional.ofNullable(options.getValue("glob"))
                .map(glob -> STR."glob:\{glob.toString()}")
                .orElseGet(() -> Optional.ofNullable(options.getValue("regex"))
                        .map(Object::toString)
                        .orElse(null));
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher(syntax);
        Path path = Path.of(dirPath);
        try {
            Files.walkFileTree(path, new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (pathMatcher.matches(file.getFileName())) {
                        System.out.println(file.toFile().getAbsoluteFile().getPath());
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
