package com.uke16.tools.jsearch.command;

public interface ICommandRegistry {

    ICommand getCommand(String name);

    void registry(ICommand... commands);
}
