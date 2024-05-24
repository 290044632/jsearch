package com.uke16.tools.jsearch.command;

public class CommandRegistryFactory {

    public static ICommandRegistry getDefault() {
        ICommandRegistry registry = new DefaultCommandRegistry();
        registry.registry(new VersionCommand(), new HelpCommand(), new SearchCommand());
        return registry;
    }
}
