package com.uke16.tools.jsearch.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultCommandRegistry implements ICommandRegistry {
    private List<ICommand> commands;

    public DefaultCommandRegistry() {
        this.commands = new ArrayList<>();
    }

    @Override
    public ICommand getCommand(String name) {
        return this.commands.stream()
                .filter(cmd -> name.equals(cmd.getName()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void registry(ICommand... commands) {
        this.commands.addAll(Arrays.asList(commands));
    }
}
