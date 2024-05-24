package com.uke16.tools.jsearch.command;

public class VersionCommand implements ICommand {
    @Override
    public String getName() {
        return "v";
    }

    @Override
    public void execute(IOptions options) {
        System.out.format("JSearch version 1.0.0");
    }
}
