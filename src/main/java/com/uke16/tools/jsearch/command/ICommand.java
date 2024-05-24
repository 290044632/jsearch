package com.uke16.tools.jsearch.command;

public interface ICommand {
    String getName();

    void execute(IOptions options);

}
